package com.gmy;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

import java.sql.SQLException;

public class codeGenerator {
    static final String URL="jdbc:mysql://localhost:3306/book_manager?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";

    public static void main(String[] args) throws SQLException {
        FastAutoGenerator.create(URL,"root","020331")
                .globalConfig(builder -> builder.outputDir("D:\\test"))
                .strategyConfig(builder -> builder.addInclude("book","inf","user"))
                .execute();
         }
}
