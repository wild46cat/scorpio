package com.xueyou.scorpio.auth.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @RequestMapping("/authTest")
    public int authTest() {
        return 0;
    }

    @RequestMapping("/authTest2")
    @RequiresPermissions("eat")
    public int authTest2() {
        return 0;
    }
}
