package com.example.demo.controller;


import com.example.demo.config.ResponseBean;
import com.example.demo.service.impl.MenuService;
import com.example.demo.vo.MenuList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/menu")
@Api(tags = "菜单管理")
public class MenuController {

    @Resource
    private MenuService menuService;

    @GetMapping("/list")
    @ApiOperation("获取菜单列表")
    public ResponseBean<MenuList> list(){
        MenuList menuList = menuService.list(0);
        return new ResponseBean<>(true,menuList);
    }
}
