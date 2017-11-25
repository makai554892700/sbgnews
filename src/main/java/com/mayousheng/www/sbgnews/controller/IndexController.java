package com.mayousheng.www.sbgnews.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    private Logger log = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/test")
    @ResponseBody
    public String index(@RequestBody String str) {
        return "Hello world.str=" + str + ";resource="
                + IndexController.class.getResource(str);
    }

}
