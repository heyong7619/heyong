package com.shanghai.crm.settings.controller;

import com.shanghai.crm.base.constants.CrmConstants;
import com.shanghai.crm.base.constants.CrmExceptionEnum;
import com.shanghai.crm.base.exception.CrmException;
import com.shanghai.crm.settings.bean.User;
import com.shanghai.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(User user, Model model, HttpServletRequest request){
        try{
            //获取客户端的ip地址
            String address = request.getRemoteAddr();
            user.setAllowIps(address);
            user = userService.login(user);
            //用户登录成功,把用户信息保存在session中
            request.getSession().setAttribute(CrmConstants.LOGIN_USER,user);
            return "index";
        }catch (CrmException e){
            model.addAttribute("loginAct",user.getLoginAct());
            model.addAttribute("mess",e.getMessage());

        }
        return "../../login";
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute(CrmConstants.LOGIN_USER);
        return "../../login";
    }

}
