package com.gmy.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmy.common.lang.Result;
import com.gmy.entity.Book;
import com.gmy.entity.User;
import com.gmy.mapper.BookMapper;
import com.gmy.service.IBookService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 如月十八
 * @since 2022-01-25
 */
@Api(value = "book",tags = {"书籍操作接口"})
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;
    ObjectMapper objectMapper=new ObjectMapper();

    @ApiOperation(value = "增加书籍",notes = "id为空,描述可以为空,其他不能为空;允许重名")
    @ApiResponses({
            @ApiResponse(code=200,message = "操作成功",response = User.class)
    })
    @PostMapping("/create")
    public String create(@RequestBody Book book) throws JsonProcessingException {
        //添加时注意不需要带上时间，后台自动加入，排查1.5h
        System.out.println(book);
        int res=bookService.create(book);
        Result result;
        if(res==1){
            result=Result.succ(res);
        }else{
            result=Result.fail("创建失败");
        }

        return objectMapper.writeValueAsString(result);
    }

    @ApiOperation(value = "查看某本书籍",notes = "使用id来查询")
    @GetMapping("/retrieve/{id}")
    public String retrieve(@PathVariable Integer id) throws JsonProcessingException {
        Book book= bookService.retrieve(id);
//        Result result=Result.succ(book);
        Result result=new Result();
        result=Result.succ(book);
        return objectMapper.writeValueAsString(result);
    }

    @ApiOperation(value = "分页查看全部书籍",notes = "参数为当前页和页码大小")
    @GetMapping("/listAll/{cur}/{size}")
    public String listAll(@PathVariable Integer cur,@PathVariable Integer size) throws JsonProcessingException {
        List<Book> books=bookService.listAll(cur,size);
        Result result=Result.succ(books);
        return objectMapper.writeValueAsString(result);
    }

    @ApiOperation(value = "分页查看某类书籍",notes = "参数为种类名称,当前页和页码大小")
    @GetMapping("/listKind/{kind}/{cur}/{size}")
    public String listKind(@PathVariable String kind,@PathVariable Integer cur,@PathVariable Integer size) throws JsonProcessingException {
        List<Book> books=bookService.listKind(kind,cur,size);
        Result result=Result.succ(books);
        return objectMapper.writeValueAsString(result);
    }

    @ApiOperation(value = "更新图书信息",notes = "参数为图书对象")
    @PostMapping("/update")
    public String update(Book book) throws JsonProcessingException {
        int res=bookService.update(book);
        Result result;
        if(res==1){
            result=Result.succ(res);
        }else{
            result=Result.fail("修改失败");
        }
        return objectMapper.writeValueAsString(result);
    }

    @ApiOperation(value = "删除图书信息",notes = "参数为图书id")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) throws JsonProcessingException {
        int res=bookService.delete(id);
        Result result;
        if(res==1){
            result=Result.succ(res);
        }else{
            result=Result.fail("修改失败");
        }
        return objectMapper.writeValueAsString(result);
    }
}

