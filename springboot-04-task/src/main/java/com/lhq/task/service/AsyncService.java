package com.lhq.task.service;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Service//加入容器
public class AsyncService {
    //告诉spring这是异步方法
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中...");
    }
}
