package com.gmy.controller;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmy.common.lang.Result;
import com.gmy.entity.Inf;
import com.gmy.service.IInfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 借阅信息管理 前端控制器
 * </p>
 *
 * @author 如月十八
 * @since 2022-01-25
 */
@RestController
//@JsonIgnoreProperties
@Api(value = "inf", tags = {"借阅操作接口"})
@RequestMapping("/inf")
public class InfController {
    @Autowired
    private IInfService infService;
    ObjectMapper objectMapper = new ObjectMapper();

    @ApiOperation(value = "增加借阅信息", notes = "读者和图书名是必须的,时间自动填充")
    @PostMapping("/create")
    public String create(@RequestBody Inf inf) throws JsonProcessingException {
        System.out.println(inf);
        Result result = infService.create(inf);
        return objectMapper.writeValueAsString(result);
    }

    @ApiOperation(value = "修改借阅信息", notes = "需要该记录id,修改时间自动填充")
    @PostMapping("/update")
    public String update(@RequestBody Inf inf) throws JsonProcessingException {
        Result result = infService.update(inf);
        return objectMapper.writeValueAsString(result);
    }

    //注意一一对应,自己造的数据会报异常
    @ApiOperation(value = "查看全部借阅信息", notes = "")
    @GetMapping("/listAll/{cur}/{size}")
    public String litAll(@PathVariable int cur, @PathVariable int size) throws JsonProcessingException {
        Result result = infService.listAll(cur, size);
        return objectMapper.writeValueAsString(result);
    }
}

