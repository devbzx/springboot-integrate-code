package com.atlhq.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/*
* 搭建基本环境
* 1、导入数据库文件，创建出department和employee表
* 2、创建JavaBean对象，封装数据库数据
* 3、整合mybatis操作数据库
*   1）配置数据源
*   2)使用注解版的mybatis
*       1、@MapperScanner扫描包
*
* 快速体验缓存
*   1、开启基于注解的缓存@EnableCaching
*   2、标注注解即可
*       @Cacheable
*       @CacheEvict
*       @CachePut
* 默认使用的是ConcurrentMapCacheManager==ConcurrentMapCache；将数据保存在
* ConcurrentMap
* 开发中使用缓存中间件：redis、memcached、ehcache；
* 整合redis作为缓存
* redis是一个开源（BSD许可）的，内存中的数据结构存储系统，可以用作数据库、缓存和消息中间件。
*   1、安装redis：使用docker
*   2、引入redis的starter
*   3、配置redis
*   4、测试缓存
*       原理：CacheManager==Cache缓存组件来实际给缓存中存取数据
*       1）引入redis的starter，容器中保存的是RedisCacheManager
*       2）RedisCacheManager帮我们创建RedisCache来作为缓存组件；RedisCache通过操作redis缓存
*       3）默认保存数据k-v都是obj；利用序列化保存；如何保存json
*           1、引入redis的starter，CacheManager变为RedisCacheManager；
*           2、默认创建的RedisCacheManager操作redis的时候使用的是RedisTemplate<Object,Object>
            3、RedisTemplate<Object,Object>是 默认使用jdk的序列化机制
         4）自定义CacheManager
* */
@MapperScan("com.atlhq.cache.mapper")
@SpringBootApplication
@EnableCaching
public class Springboot01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01CacheApplication.class, args);
    }

}
