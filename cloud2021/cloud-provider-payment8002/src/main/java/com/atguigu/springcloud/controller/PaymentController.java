package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.sercice.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.atguigu.springcloud.Constant.HTTP_ERROR;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PutMapping
    public CommonResult create(@RequestBody Payment payment) {
        if (paymentService.create(payment)) {
            return new CommonResult(serverPort);
        }
        return new CommonResult(HTTP_ERROR, serverPort);
    }

    @GetMapping("/{id}")
    public CommonResult select(@PathVariable("id") long id) {
        return new CommonResult(paymentService.getPaymentById(id), serverPort);
    }

    @RequestMapping(value = "/zk")
    public String paymentZk() {
        return "spring cloud with zookeeper" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
