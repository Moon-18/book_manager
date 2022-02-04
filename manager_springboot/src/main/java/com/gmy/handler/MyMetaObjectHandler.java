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

//        Date now = new Date(); // 创建一个Date对象，获取当前时间
//        // 指定格式化格式
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//        String s=f.format(now); // 将当前时间袼式化为指定的格式

//        this.setFieldValByName("outDate",s,metaObject);
//        this.setFieldValByName("createDate",s,metaObject);
        System.out.println(LocalDateTime.now());
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "outDate", LocalDateTime.class, LocalDateTime.now());
    }

    //更新时的填充字段
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill...");
        this.setFieldValByName("inDate",new Date(),metaObject);
    }
}
