package com.example.demo.service.impl;

import com.example.demo.mapper.MenuMapper;
import com.example.demo.service.IMenuService;
import com.example.demo.vo.MenuList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuService implements IMenuService {

    @Resource
    private MenuMapper menuMapper;

    /**
     * parentMenuId 是0的时候查询最上级
     * @return
     */
    @Override
    public List<MenuList> list(int i) {
        List<MenuList> menus = menuMapper.selectListByParentMenuId(i);
        menus.forEach(menu -> {
            List<MenuList> list = this.list(menu.getId());
            menu.setChildren(list);
        });
        return menus;
    }
}
