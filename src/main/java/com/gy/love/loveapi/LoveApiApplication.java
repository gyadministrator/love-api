package com.gy.love.loveapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@EnableAutoConfiguration
@SpringBootApplication
@MapperScan("com.gy.love.loveapi.mapper")
public class LoveApiApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(SpringApplication.class);
    }

    public static void main(String[] args) { SpringApplication.run(LoveApiApplication.class, args);}
}
