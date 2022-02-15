package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "defaultPaymentTimeOutFallbackMethod")
public class PaymentHystrixController {

    @Autowired
    private PaymentFeignClient paymentFeignClient;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentFeignClient.paymentInfo_OK(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    // @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
    //         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    // })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) throws InterruptedException {
        return paymentFeignClient.paymentInfo_TimeOut(id);
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "80一对一降级处理";
    }

    public String defaultPaymentTimeOutFallbackMethod() {
        return "80默认降级处理";
    }

    @GetMapping("/payment/hystrix/breaker/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 开启服务熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"), //单次窗口期的判断次数（小于该次数不会熔断）
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//单次窗口期时间
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")//单次窗口期成功率要求
    })
    public String paymentInfo_breaker(@PathVariable("id") Integer id) throws Exception {
        if (id < 1) {
            throw new Exception();
        }
        return paymentFeignClient.paymentInfo_OK(id);
    }
}
