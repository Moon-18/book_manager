package com.gmy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmy.common.lang.Result;
import com.gmy.entity.User;
import com.gmy.service.IUserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 图书馆的管理员列表 前端控制器
 * </p>
 *
 * @author 如月十八
 * @since 2022-01-25
 */
@Api(value = "user", tags = {"用户操作接口"})
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    ObjectMapper objectMapper = new ObjectMapper();

    // http://localhost:8081/user/retrieve/1911834200@qq.com
    @ApiOperation(value = "取得个人信息", notes = "通过账号获得数据")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功", response = User.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户的账号")
    })
    @GetMapping("/retrieve/{account}")
    public String retrieve(@PathVariable String account) throws JsonProcessingException {
        User user = iUserService.retrieve(account);
        Result result = Result.succ(user);
        return objectMapper.writeValueAsString(result);
    }

    // http://localhost:8081/user/loginIn/1911834200@qq.com/admin/admin
    @PostMapping("/loginIn")
    public String loginIn(@RequestBody User user) throws JsonProcessingException {
        Result result = iUserService.loginIn(user.getAccount(), user.getPassword(), user.getType());
        return objectMapper.writeValueAsString(result);
    }

    // http://localhost:8081/user/register/1911834200@qq.com/admin/admin/测试一下
    // http://localhost:8081/user/register/123456@qq.com/admin/admin/测试一下
    @PostMapping("/register")
    public String register(@RequestBody User user) throws JsonProcessingException {
        int res = iUserService.register(user);
        Result result = new Result();
        if (res == 1) {
            //注册成功
            result = Result.succ(null);
        } else if (res == 0) {
            result = Result.fail("注册失败,用户名重复");
        }
        return objectMapper.writeValueAsString(result);
    }

    //只让修改密码和用户名
    // http://localhost:8081/user/update/123456@qq.com/pwd/测试好几下
    @PostMapping("/update")
    public String update(User user) throws JsonProcessingException {
        int res = iUserService.update(user);
        Result result = new Result();
        if (res == 1) {
            //修改成功
            result = Result.succ(null);
        } else if (res == 0) {
            result = Result.fail("修改失败");
        }
        return objectMapper.writeValueAsString(result);
    }

    @GetMapping("/listAll/{cur}/{size}")
    public String listAll(@PathVariable int cur, @PathVariable int size) throws JsonProcessingException {
        List<User> users = iUserService.list(cur, size);
        Result result = Result.succ(users);
        return objectMapper.writeValueAsString(result);
    }

    @PostMapping("/photo/{id}")
    public String photo(@RequestPart("photo") MultipartFile multipartFile, @PathVariable String id) throws IOException {
//        log.info(multipartFile.getSize());
        if (multipartFile.isEmpty())
            log.error("文件为空");
        if (!multipartFile.isEmpty()) {
            //确定好文件名称
            String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\";
            String[] back = Objects.requireNonNull(multipartFile.getOriginalFilename()).split("[.]");//文件后缀
            String backName = "." + back[1];
            String fileName = path + id + backName;
            //查看文件是否存在,若存在,则删除
            File file = new File(fileName);
            if (file.exists()) {
                boolean res = file.delete();
            }
            //创建文件

            multipartFile.transferTo(file);
            return objectMapper.writeValueAsString(Result.succ(multipartFile.getSize()));
        }
        return objectMapper.writeValueAsString(Result.fail("上传失败"));
    }
}

