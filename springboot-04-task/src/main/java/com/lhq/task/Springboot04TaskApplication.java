package com.lhq.task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync//开启异步
@EnableScheduling//开启定时任务注解
@SpringBootApplication
public class Springboot04TaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot04TaskApplication.class, args);
    }
}
