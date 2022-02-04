package com.gmy.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    //插入时的填充字段
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill...");

        System.out.println(LocalDateTime.now());
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "outDate", LocalDateTime.class, LocalDateTime.now());
    }

    //更新时的填充字段
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill...");
        this.strictUpdateFill(metaObject, "inDate", LocalDateTime.class, LocalDateTime.now());
    }
}
