package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.CustomPage;
import com.example.demo.entity.Goods;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.service.IGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class GoodsService implements IGoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public Page<Goods> list(CustomPage<Goods> page) {

        Goods search = page.getSearch();

        QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(search.getGoodsName())) {
            goodsQueryWrapper.like("goods_name", search.getGoodsName());

        }


        Page<Goods> goodsPage = goodsMapper.selectPage(page, goodsQueryWrapper);
        return goodsPage;
    }
}
