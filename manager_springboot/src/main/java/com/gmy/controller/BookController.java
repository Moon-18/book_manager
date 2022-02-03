package com.gmy.controller;


import com.gmy.entity.Book;
import com.gmy.entity.User;
import com.gmy.mapper.BookMapper;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 高明岩
 * @since 2022-01-25
 */
@Api(value = "book",tags = {"书籍相关操作"})
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookMapper bookMapper;

    @ApiOperation(value = "增加书籍",notes = "id为空,描述可以为空,其他不能为空;允许重名")
    @ApiResponses({
            @ApiResponse(code=200,message = "操作成功",response = User.class)
    })
    @PostMapping("/create")
    public String create(@RequestBody Book book){
        System.out.println(book);
        return "";
    }
}

