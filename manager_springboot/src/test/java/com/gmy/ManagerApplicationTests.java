package com.gmy;

import com.gmy.entity.User;
import com.gmy.mapper.UserMapper;
import com.gmy.service.IUserService;
import com.gmy.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ManagerApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
//        User user=new User();
//        user.setName("管理员");
//        user.setAccount("1911834200@qq.com");
//        user.setPassword("admin");
//        user.setType("admin");
//        int res= userMapper.insert(user);
//        System.out.println(res);
//        System.out.println(user);
        List<User> users=userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Autowired
    UserServiceImpl userService;
    @Test
    public void myTest(){
//        IUserService iUserService=new UserServiceImpl();
        List<User> users=userService.list();
        users.forEach(System.out::println);
    }
}
