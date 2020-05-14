package com.example.demo.vo;

import lombok.Data;

import java.util.List;

@Data
public class MenuList {

    private Integer id;

    private String menuName;

    private String menuUrl;

    private Integer parentMenuId;

    private List<MenuList> children;
}
