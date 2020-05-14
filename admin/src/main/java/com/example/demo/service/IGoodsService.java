package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.CustomPage;
import com.example.demo.entity.Goods;

public interface IGoodsService {

    Page<Goods> list(CustomPage<Goods> i);

}
