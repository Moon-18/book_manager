package com.gmy.service;

import com.gmy.entity.User;
import com.gmy.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
//测试的时候需要加上spring boot测试的注解
@SpringBootTest
class IUserServiceTest {
    @Autowired
    UserServiceImpl userService;

    @Test
    void loginIn() {
        String account="user";
        String password="123456";
        String type="user";
        String name="user";
        int res=userService.loginIn(account,password,type);
        System.out.println(res);

    }

    @Test
    void register() {
        String account="user";
        String password="123456";
        String type="user";
        String name="user";
        int res=userService.register(account,password,type,name);
        System.out.println(res);
    }

    @Test
    void retrieve() {
        String account="user";
        User user=userService.retrieve(account);

        System.out.println(user);
    }

    @Test
    void update() {
        String account="user";
        User user=userService.retrieve(account);

        String name="user";

        user.setName(name);
        int res=userService.update(user);
        System.out.println(res);
    }
}
