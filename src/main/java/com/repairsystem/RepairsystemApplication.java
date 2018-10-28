package com.repairsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.repairsystem.dao")
public class RepairsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepairsystemApplication.class, args);
    }
}
