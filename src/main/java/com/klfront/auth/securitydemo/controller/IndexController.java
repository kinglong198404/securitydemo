package com.klfront.auth.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 默认控制器
 *
 * @author: LuJinlong
 * @created: 2025/02/11 14:55
 **/
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        int length = "index".length();
        return "index";
    }
}
