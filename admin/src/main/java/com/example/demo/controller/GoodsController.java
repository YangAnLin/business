package com.example.demo.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.config.ResponseBean;
import com.example.demo.entity.CustomPage;
import com.example.demo.entity.Goods;
import com.example.demo.service.impl.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goods")
@Api(tags = "商品管理")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @PostMapping("/list")
    @ApiOperation("获取商品列表")
    public ResponseBean<Page<Goods>> list(@RequestBody CustomPage<Goods> page){
        return new ResponseBean<>(true,goodsService.list(page));
    }
}
