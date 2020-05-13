package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.config.UnicomResponseEnums;
import com.example.demo.config.UnicomRuntimeException;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import com.example.demo.vo.Register;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserService implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public String login(String username, String password) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", username);
        userQueryWrapper.eq("password", password);
        Integer integer = userMapper.selectCount(userQueryWrapper);
        if (integer == 0) {
            throw new UnicomRuntimeException(UnicomResponseEnums.LOGIN_026);
        }else{
            return "登录成功";
        }
    }

    @Override
    public String register(Register register) {

        // 判断密码和确认密码是否一致
        if (!register.getPassword().equals(register.getConfirmPassword())) {
            throw new UnicomRuntimeException(UnicomResponseEnums.LOGIN_027);
        }

        // 查询有没有这个用户
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", register.getUsername());
        Integer integer = userMapper.selectCount(userQueryWrapper);
        if (integer != 0) {
            // 用户已存在
            throw new UnicomRuntimeException(UnicomResponseEnums.LOGIN_029);
        }

        // 插入数据
        User user = new User().setUsername(register.getUsername()).setCreateTime(new Date()).setPassword(register.getPassword());
        if (userMapper.insert(user) != 1) {
            throw new UnicomRuntimeException(UnicomResponseEnums.LOGIN_028);
        }

        return "注册成功";
    }
}
