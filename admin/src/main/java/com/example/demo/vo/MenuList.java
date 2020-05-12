package com.example.demo.vo;

import com.example.demo.entity.Menu;
import lombok.Data;

import java.util.List;

@Data
public class MenuList extends Menu {

    private MenuList children;
}
