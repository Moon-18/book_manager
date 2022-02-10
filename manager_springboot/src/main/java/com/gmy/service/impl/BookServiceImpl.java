package com.gmy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gmy.common.lang.Result;
import com.gmy.entity.Book;
import com.gmy.mapper.BookMapper;
import com.gmy.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 如月十八
 * @since 2022-01-25
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Integer create(Book book) {
        return bookMapper.insert(book);
    }

    @Override
    public Book retrieve(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public List<Book> listAll(int cur, int size) {
        Page<Book> page = new Page<>(cur, size);
        bookMapper.selectPage(page, null);
//        System.out.println(page.getRecords());
        return page.getRecords();
    }

    @Override
    public List<Book> listKind(String kind, int cur, int size) {
        Page<Book> page = new Page<>(cur, size);
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("kind", kind);
        bookMapper.selectPage(page, wrapper);
        return page.getRecords();
    }

    @Override
    public Result update(Book book) {
//        System.out.println(book);
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("name", book.getName());
        Book target = bookMapper.selectOne(wrapper);
        if (target != null) {
            //不为空，说明已经存在重名图书，错误
            return Result.fail(435, "图书名已存在");
        }
        //没有问题
        bookMapper.updateById(book);
        return Result.succ(null);
    }

    @Override
    public Result delete(Long id) {
        int res = bookMapper.deleteById(id);
        return Result.succ(200, "删除成功", null);
    }
}
