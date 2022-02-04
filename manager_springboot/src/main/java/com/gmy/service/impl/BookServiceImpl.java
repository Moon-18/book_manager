package com.gmy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gmy.entity.Book;
import com.gmy.mapper.BookMapper;
import com.gmy.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
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
    public List<Book> listAll(int cur,int size) {
        Page<Book> page=new Page<>(cur,size);
        bookMapper.selectPage(page,null);
        return page.getRecords();
    }

    @Override
    public List<Book> listKind(String kind,int cur,int size) {
        Page<Book> page=new Page<>(cur,size);
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("kind",kind);
        bookMapper.selectPage(page,wrapper);
        return page.getRecords();
    }

    @Override
    public Integer update(Book book) {
        return bookMapper.updateById(book);
    }

    @Override
    public Integer delete(Integer id) {
        return bookMapper.deleteById(id);
    }
}
