package com.example.demo.controller;


import com.example.demo.config.ResponseBean;
import com.example.demo.service.impl.UserService;
import com.example.demo.vo.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public ResponseBean<String> login(@RequestBody Login body){
        String login = userService.login(body.getUsername(), body.getPassword());
        return new ResponseBean<>(true,login);
    }
}
