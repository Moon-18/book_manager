package com.gmy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    public Docket
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.gmy.controller")).build()
                ;
    }

    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("gmy","sdu计算机科学与技术", "1911834200@qq.com");
        return new ApiInfo(
                "图书信息管理系统后端Api",
                "Api文档描述 2022年1月23日22:00:08",
                "1.0.0",
                "https://www.loong.com",
                contact,
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
