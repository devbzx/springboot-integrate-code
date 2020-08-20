package com.atlhq.cache;

import com.atlhq.cache.bean.Employee;
import com.atlhq.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Springboot01CacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作k-v都是字符串
    @Autowired
    RedisTemplate redisTemplate;//k-v都是对象
    @Autowired
    RedisTemplate<Object,Employee> employeeRedisTemplate;

    /*
    *  String、List、Set、Hash[散列]、ZSet[有序集合]
    * stringRedisTemplate.opsForValue()[String]
    * stringRedisTemplate.opsForList()[list]
    * stringRedisTemplate.opsForHash()[Hash]
    * stringRedisTemplate.opsForSet()[Set]
    * stringRedisTemplate.opsForZSet()[ZSet]
    * */
    @Test
    public void myTest01(){
        //给redis中保存数据
        stringRedisTemplate.opsForValue().append("msg","hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","1");

    }
    @Test
    public void myTest02(){
        Employee byId = employeeMapper.getById(1);
        //默认保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
        //redisTemplate.opsForValue().set("emp-01",byId);
        //1、将数据以json方式保存
        //  （1）自己将对象转为json
        //  （2）redisTemplate默认的序列化规则；改变默认的序列化规则；
        employeeRedisTemplate.opsForValue().set("emp-01",byId);
    }
    @Test
    void contextLoads() {
        Employee byId = employeeMapper.getById(1);
        System.out.println(byId);
    }

}
