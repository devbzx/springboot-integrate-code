package com.atlhq.user.service;

import com.atlhq.ticket.service.TicketService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Reference
    TicketService ticketService;
    public void hello(){
        System.out.println("买到票了："+ticketService.getTicket());
    }
}
