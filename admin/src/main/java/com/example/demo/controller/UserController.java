package com.example.demo.controller;


import com.example.demo.config.ResponseBean;
import com.example.demo.service.impl.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public ResponseBean<String> login(@RequestParam("username") String username,
                                      @RequestParam("password") String password){
        String login = userService.login(username, password);
        return new ResponseBean<>(true,login);
    }
}
