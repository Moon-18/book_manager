package com.gmy.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmy.common.lang.Result;
import com.gmy.entity.User;
import com.gmy.service.IUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * <p>
 * 图书馆的管理员列表 前端控制器
 * </p>
 *
 * @author 如月十八
 * @since 2022-01-25
 */
@Api(value = "user",tags = {"用户操作接口"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    ObjectMapper objectMapper=new ObjectMapper();

    // http://localhost:8081/user/retrieve/1911834200@qq.com
    @ApiOperation(value = "取得个人信息",notes = "通过账号获得数据")
    @ApiResponses({
        @ApiResponse(code=200,message = "操作成功",response = User.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户的账号")
    })
    @GetMapping("/retrieve/{account}")
    public String retrieve(@PathVariable String account) throws JsonProcessingException {
        User user=iUserService.retrieve(account);
        Result result=Result.succ(user);

//        System.out.println(objectMapper.writeValueAsString(user));

//        HttpServletResponse response = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
//        System.out.println("Default charset: " + response.getCharacterEncoding());

        return objectMapper.writeValueAsString(result);
    }
    // http://localhost:8081/user/loginIn/1911834200@qq.com/admin/admin
    @GetMapping("/loginIn/{account}/{password}/{type}")
    public String loginIn(@PathVariable String account,@PathVariable String password,@PathVariable String type) throws JsonProcessingException {
        int res=iUserService.loginIn(account, password, type);
        Result result=new Result();
        if(res==1){
            //登录成功
            result=Result.succ(null);
        }else if(res==0){
            result=Result.fail("登录失败");
        }
        return objectMapper.writeValueAsString(result);
    }

    // http://localhost:8081/user/register/1911834200@qq.com/admin/admin/测试一下
    // http://localhost:8081/user/register/123456@qq.com/admin/admin/测试一下
    @GetMapping("/register/{account}/{password}/{type}/{name}")
    public String register(@PathVariable String account,@PathVariable String password,@PathVariable String type,@PathVariable String name) throws JsonProcessingException {
        int res=iUserService.register(account, password, type,name);
        Result result=new Result();
        if(res==1){
            //登录成功
            result=Result.succ(null);
        }else if(res==0){
            result=Result.fail("注册失败,用户名重复");
        }
        return objectMapper.writeValueAsString(result);
    }
    //只让修改密码和用户名
    // http://localhost:8081/user/update/123456@qq.com/pwd/测试好几下
    @GetMapping("/update/{account}/{password}/{name}")
    public String update(@PathVariable String account, @PathVariable String password,@PathVariable String name) throws JsonProcessingException {
        User user=new User();
        user.setAccount(account);
        user.setName(name);
        user.setPassword(password);
        int res=iUserService.update(user);
        Result result=new Result();
        if(res==1){
            //登录成功
            result=Result.succ(null);
        }else if(res==0){
            result=Result.fail("修改失败");
        }
        return objectMapper.writeValueAsString(result);
    }
}

