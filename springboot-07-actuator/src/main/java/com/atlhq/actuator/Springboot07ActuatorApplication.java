package com.atlhq.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* 自定义健康指示器
* 1、编写一个指示器 实现 HealthIndicator 接口
* 2、指示器的名字 xxxHealthIndicator
* 3、加入容器中
* */
@SpringBootApplication
public class Springboot07ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot07ActuatorApplication.class, args);
    }

}
