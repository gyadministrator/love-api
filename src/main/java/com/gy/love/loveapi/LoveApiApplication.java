package com.gy.love.loveapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
@EnableAutoConfiguration
@SpringBootApplication
@MapperScan("com.gy.love.loveapi.mapper")
public class LoveApiApplication {

    public static void main(String[] args) { SpringApplication.run(LoveApiApplication.class, args);}
}
