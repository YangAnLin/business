package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.javafx.beans.IDProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class User {

    @TableId
    private Long id;
    private String username;
    private String password;
    private String email;
    private String sex;
    private String tel;
    private Date createTime;
    private Date updateTime;

    private String token;
}
