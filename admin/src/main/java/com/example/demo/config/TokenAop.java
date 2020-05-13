package com.example.demo.config;

import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class TokenAop {

    @Resource
    private UserMapper userMapper;

    // 切点
    @Pointcut("execution(public * com.example.demo.controller.*.*(..))")
    public void log(){
    }

    /**
     * 前置通知
     */
    @Before("log()")
    public void doBeforeController(JoinPoint joinPoint) {
        MethodSignature joinPointObject = (MethodSignature) joinPoint.getSignature();
        //获得请求的方法
        Method method = joinPointObject.getMethod();

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();

        // 排除路径
        boolean flag = false;
        String requestURI = request.getRequestURI();
        switch (requestURI) {
            case "/user/login":
                flag = true;
        }


        if (!flag) {
            String token = request.getHeader("Authorization");

            // 判断token有没有
            if(token == null || StringUtils.isEmpty(token)){
                throw new UnicomRuntimeException(UnicomResponseEnums.LOGIN_030);
            }

            // 判断token对不对
            Long id = Long.valueOf(token.split("_")[0]);
            String s = userMapper.selectById(id).getToken();
            if (!token.equals(s)) {
                throw new UnicomRuntimeException(UnicomResponseEnums.LOGIN_030);
            }
        }


    }
}
