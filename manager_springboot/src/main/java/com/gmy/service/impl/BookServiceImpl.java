package com.gmy.service.impl;

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
 * @author 高明岩
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
        return null;
    }

    @Override
    public List<Book> listAll() {
        return bookMapper.selectList(null);
    }

    @Override
    public List<Book> listKind(String kind) {
        return null;
    }

    @Override
    public Integer update(Book book) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }
}
