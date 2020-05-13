package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Menu;
import com.example.demo.vo.MenuList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    @Select("select * from menu where parentMenuId = #{parentMenuId}")
    List<MenuList> selectListByParentMenuId(@Param("parentMenuId") int parentMenuId);
}
