package com.example.demo.vo;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = false)
public class MenuList {

    private MenuList children;
}
