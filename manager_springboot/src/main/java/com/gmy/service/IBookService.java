package com.gmy.service;

import com.gmy.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 如月十八
 * @since 2022-01-25
 */
public interface IBookService extends IService<Book> {
    //增加图书
//    public Integer create(String name,String writer,String kind,String comment,Integer allow,Integer curNum,Integer sumNum);
    //使用json对象来传递数据,而不用逐个字段进行传输
    public Integer create(Book book);
    //查看具体某本图书
    public Book retrieve(Integer id);
    //分页查看全部图书
    public List<Book> listAll(int cur,int size);
    //分页查看某一类图书
    public List<Book> listKind(String kind,int cur,int size);
    //更新图书信息
    public Integer update(Book book);
    //删除图书
    public Integer delete(Integer id);
}
