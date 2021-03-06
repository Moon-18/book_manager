package com.gmy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gmy.entity.Book;
import com.gmy.entity.Inf;
import com.gmy.mapper.BookMapper;
import com.gmy.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IBookServiceTest {

    @Autowired
    BookServiceImpl bookService;
    @Autowired
    BookMapper bookMapper;

    @Test
    void create() {
        Book book = new Book();
        book.setName("中国历代政治得失\n");
        book.setWriter("钱穆\n");
        book.setKind("文化");
        book.setComment("一部简明的“中国政治制度史”\n");
        book.setAllow(1);
        book.setCurNum(10);
        book.setSumNum(10);
        bookService.create(book);
//        Scanner scanner=new Scanner(System.in);
//        int i=10;
//        while(i-->0){
//            String s1=scanner.nextLine();
//            book.setName(s1);
//            s1=scanner.nextLine();
//            book.setWriter(s1);
//            s1=scanner.nextLine();
//            book.setComment(s1);
//            book.setAllow(1);
//            book.setCurNum(10);
//            book.setSumNum(10);
//            bookService.create(book);
//            System.out.println(book);
//        }
//        System.out.println("finish");
    }

    @Test
    void retrieve() {
        Inf inf = new Inf();
        inf.setReaderName("张三");
        inf.setBookName("1984");
        QueryWrapper<Book> wrapper1 = new QueryWrapper<>();
        System.out.println("书名" + inf.getBookName());
//        wrapper1.eq("name", inf.getBookName());
        wrapper1.eq("name", "飘");
        Book book = bookMapper.selectOne(wrapper1);
        System.out.println("图书" + book);
    }

    @Test
    void listAll() {
    }

    @Test
    void listKind() {
        List<Book> books = bookService.listKind("教育", 1, 5);
        books.forEach(System.out::println);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}
