package com.shanghai.crm.workbench.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanghai.crm.base.bean.ResultVo;
import com.shanghai.crm.workbench.bean.Activity;
import com.shanghai.crm.workbench.bean.ActivityQueryVo;
import com.shanghai.crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/workbench/activity/list")
    @ResponseBody
    public ResultVo<Activity> list(@RequestParam(defaultValue = "1") int page, int pageSize, ActivityQueryVo activityQueryVo){
        PageHelper.startPage(page,pageSize);
        List<Activity> activities = activityService.list();
        PageInfo<Activity> pageInfo = new PageInfo<>(activities);
        ResultVo<Activity> resultVo = new ResultVo<>();
        resultVo.setPageInfo(pageInfo);
        return resultVo;
    }
}
