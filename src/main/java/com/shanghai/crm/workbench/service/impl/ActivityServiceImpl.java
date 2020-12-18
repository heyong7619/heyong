package com.shanghai.crm.workbench.service.impl;

import com.shanghai.crm.settings.bean.User;
import com.shanghai.crm.settings.mapper.UserMapper;
import com.shanghai.crm.workbench.bean.Activity;
import com.shanghai.crm.workbench.mapper.ActivityMapper;
import com.shanghai.crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<Activity> list() {
        List<Activity> activities = activityMapper.selectAll();
        for (Activity activity : activities) {
            String owner = activity.getOwner();
            User user = userMapper.selectByPrimaryKey(owner);
            activity.setOwner(user.getName());
        }
        return activities;
    }
}
