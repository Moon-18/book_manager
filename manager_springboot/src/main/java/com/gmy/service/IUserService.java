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
 * @author 高明岩
 * @since 2022-01-25
 */
public interface IUserService extends IService<User> {

    //登录功能
    public int loginIn(String account,String password,String type);

    //注册功能
    public int register(String account,String password,String type,String name);

    //查看个人信息
    public User retrieve(String account);

    //修改个人信息
    public int update(User user);
}
