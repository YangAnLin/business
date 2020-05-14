package com.example.demo.entity;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class CustomPage<T> extends Page<T> {

    private T search;
}
