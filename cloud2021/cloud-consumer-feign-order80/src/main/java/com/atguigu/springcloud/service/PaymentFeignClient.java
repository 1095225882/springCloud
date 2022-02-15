package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//当前service的指定服务名
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentFeignClient {
    //目标的路径
    @GetMapping(value = "payment/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
