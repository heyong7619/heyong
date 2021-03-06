package com.shanghai.crm.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
public class ViewController {
    @RequestMapping({"/toView/{firstView}/{secondView}","/toView/{firstView}"})
    public String toView(@PathVariable(value = "firstView",required = false)String firstView,
                         @PathVariable("secondView")String secondView){

        if(secondView != null){
            return File.separator+firstView+File.separator+secondView;
        }else {
            return File.separator+firstView;
        }
    }

}
