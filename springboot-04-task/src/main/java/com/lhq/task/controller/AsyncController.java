package com.lhq.task.controller;

import com.lhq.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
    @Autowired
    AsyncService asyncService;
    @GetMapping("hello")
    public String hello(){
        asyncService.hello();
        return "hello";
    }
}
