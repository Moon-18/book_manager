package com.gmy.service;

import com.gmy.common.lang.Result;
import com.gmy.entity.Inf;
import com.gmy.service.impl.InfServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IInfServiceTest {
    @Autowired
    InfServiceImpl infService;

    @Test
    void create() {
        Inf inf = new Inf();
        inf.setReaderName("张三");
        inf.setBookName("1984");
        System.out.println(infService.create(inf));
    }

    @Test
    void update() {
        Inf inf = new Inf();
        inf.setBookName("红楼梦");
        inf.setReaderName("张三");
        Result result = infService.update(inf);
        System.out.println(result);
    }

    @Test
    void listAll() {
//        List<Inf> infList = infService.listAll(1, 1);
//        infList.forEach(System.out::println);
        Result result = infService.listAll(1, 10);
        System.out.println(result);
    }
}
