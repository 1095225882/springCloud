package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class PaymentController {

    @Autowired
    private PaymentFeignClient paymentFeignClient;

    @GetMapping("/select/{id}")
    private CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignClient.getPaymentById(id);
    }
}
