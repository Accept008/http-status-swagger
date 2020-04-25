package com.example;

import cn.soundbus.spring.swagger.boot.autoconfigure.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2Doc
@ComponentScan({"cn.soundbus","com.example.qztc"})
public class HttpStatusSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpStatusSwaggerApplication.class, args);
    }

}
