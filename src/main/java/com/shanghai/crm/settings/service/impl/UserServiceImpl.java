package com.shanghai.crm.settings.service.impl;

import com.shanghai.crm.base.constants.CrmExceptionEnum;
import com.shanghai.crm.base.exception.CrmException;
import com.shanghai.crm.base.util.DateTimeUtil;
import com.shanghai.crm.base.util.MD5Util;
import com.shanghai.crm.settings.bean.User;
import com.shanghai.crm.settings.mapper.UserMapper;
import com.shanghai.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(User user) {
        //加密
        user.setLoginPwd(MD5Util.getMD5(user.getLoginPwd()));
        //取出ip地址信息
        String address = user.getAllowIps();
        //把ip地址置为null
        user.setAllowIps(null);
        user = userMapper.selectOne(user);
        if(user == null){
            //用户名或密码错误
            throw new CrmException(CrmExceptionEnum.LOGIN_ACCOUNT_ERROR);
        }else {
            //判断账户是否失效
            if(user.getExpireTime().compareTo(DateTimeUtil.getSysTime()) < 0 ){
                throw new CrmException(CrmExceptionEnum.LOGIN_EXPIRE_EXCEPTION);
            }
            //用户是否被锁定
            if("0".equals(user.getLockState())){
                throw new CrmException(CrmExceptionEnum.LOGIN_LOCK_EXCEPTION);
            }
            //ip地址是否合法
            if(user.getAllowIps().contains(address)){
                throw new CrmException(CrmExceptionEnum.LOGIN_IP_EXCEPTION);
            }
        }
        return user;
    }
}
