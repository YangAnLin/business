package com.example.demo.entity;

import lombok.Data;

@Data
public class Menu {
    private Integer id;

    private String menuName;

    private String menuUrl;

    private Integer parentMenuId;

}
