package com.eking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by apple on 17/6/2.
 */
@Controller
public class HelloController {
    @RequestMapping("/")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("host","欢迎");
        modelMap.addAttribute("path","/1.jpg");
        return "index";
    }
}
