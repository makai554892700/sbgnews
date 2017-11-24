package com.mayousheng.www.sbgnews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/test")
    @ResponseBody
    public String index(@RequestBody String str) {
        return "Hello world.str=" + str + ";resource=" + IndexController.class.getResource(str);
    }

}
