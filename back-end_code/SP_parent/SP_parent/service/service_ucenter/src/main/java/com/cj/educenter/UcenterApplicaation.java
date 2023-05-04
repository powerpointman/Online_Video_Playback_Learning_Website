package com.cj.educenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.cj"})
@MapperScan("com.cj.educenter.mapper")
public class UcenterApplicaation {
    public static void main(String[] args) {
        SpringApplication.run(UcenterApplicaation.class, args);}
}
