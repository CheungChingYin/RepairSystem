package com.repairsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.repairsystem"})
@MapperScan(basePackages = {"com.repairsystem.dao"})
public class RepairsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepairsystemApplication.class, args);
    }
}
