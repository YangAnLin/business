package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private String sex;
    private String tel;
    private Date createTime;
    private Date updateTime;

}
