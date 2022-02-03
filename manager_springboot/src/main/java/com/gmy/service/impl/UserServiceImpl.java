package com.gmy.service.impl;

import com.gmy.entity.User;
import com.gmy.mapper.UserMapper;
import com.gmy.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 图书馆的管理员列表 服务实现类
 * </p>
 *
 * @author 高明岩
 * @since 2022-01-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int loginIn(String account, String password,String type) {
        Integer id=userMapper.getId(account);
        User user=userMapper.selectById(id);
        String Account=user.getAccount();
        String Password=user.getPassword();
        String Type=user.getType();
        if(Account.equals(account)&&Password.equals(password)&&Type.equals(type)){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int register(String account, String password, String type,String name) {
        User user=new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setType(type);
        user.setName(name);
//        System.out.println(user);
        return userMapper.insert(user);
    }

    @Override
    public User retrieve(String account) {
        int id=userMapper.getId(account);
        return userMapper.selectById(id);
    }

    @Override
    public int update(User user) {
        int id=userMapper.getId(user.getAccount());
        user.setId(id);
        return userMapper.updateById(user);
    }
}
