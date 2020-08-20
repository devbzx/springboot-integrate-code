package com.lhq.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* spring boot默认支持两种技术来和ES交互
* 1、Jest（默认不生效）
*   需要导入Jest的工具包
* 2、SpringData ElasticSearch
*
* */
@SpringBootApplication
public class Springboot03elasticApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot03elasticApplication.class, args);
    }

}
