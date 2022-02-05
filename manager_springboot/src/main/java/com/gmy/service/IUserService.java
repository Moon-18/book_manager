package com.gmy.service;

import com.gmy.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gmy.mapper.UserMapper;

import java.util.List;

/**
 * <p>
 * 图书馆的管理员列表 服务类
 * </p>
 *
 * @author 如月十八
 * @since 2022-01-25
 */
public interface IUserService extends IService<User> {

    //登录功能
    public int loginIn(String account,String password,String type);

    //注册功能
    public int register(User user);

    //查看个人信息
    public User retrieve(String account);

    //修改个人信息
    public int update(User user);

    //分页查看全部用户信息,用于管理员管理
    public List<User> list(int cur,int size);
}
