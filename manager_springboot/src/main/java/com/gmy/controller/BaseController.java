package com.gmy.controller;

import com.gmy.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServlet;

public class BaseController {
    @Autowired
    HttpServlet request;

    @Autowired
    RedisUtil redisUtil;
}
