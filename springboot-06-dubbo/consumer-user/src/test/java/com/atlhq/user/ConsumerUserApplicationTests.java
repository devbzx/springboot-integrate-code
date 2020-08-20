package com.atlhq.user;

import com.atlhq.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.soap.Addressing;

@SpringBootTest
class ConsumerUserApplicationTests {
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        userService.hello();
    }

}
