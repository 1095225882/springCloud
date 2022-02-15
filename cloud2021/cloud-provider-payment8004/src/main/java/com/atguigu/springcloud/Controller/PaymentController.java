package com.atguigu.springcloud.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/zk")
    public String paymentZk() {
        return "spring cloud with zookeeper" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
