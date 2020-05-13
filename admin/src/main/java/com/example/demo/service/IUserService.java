package com.example.demo.service;

import com.example.demo.vo.Register;

public interface IUserService {

    String login(String username, String password);

    String register(Register register);

}
