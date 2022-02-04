package com.gmy.service;

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
        Inf inf=new Inf();
        inf.setBookId(1489485982758727681L);
        inf.setReaderId(1489590815759024129L);
        infService.create(inf);
    }

    @Test
    void update() {
        Inf inf=new Inf();
        inf.setId(1489594293436817410L);
        inf.setBookId(1489485982758727681L);
        inf.setReaderId(1489590815759024129L);
        inf.setState("借出中");
        infService.update(inf);
    }

    @Test
    void listAll() {
        List<Inf> infList=infService.listAll(1,1);
        infList.forEach(System.out::println);
    }
}
