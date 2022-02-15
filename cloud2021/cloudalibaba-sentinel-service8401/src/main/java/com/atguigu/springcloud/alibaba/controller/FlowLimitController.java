package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("testa")
    public String testA() {
        return "testA";
    }

    @GetMapping("testb")
    @SentinelResource(value = "testb", blockHandler = "blockTest", fallback = "fallbackTest")
    public String testB(@RequestParam(value = "p1", required = true) String p1) throws InterruptedException {
        Thread.sleep(1000);
        return "testB";
    }

    public String blockTest(String p1, BlockException e) {
        return "blocked";
    }
    public String fallbackTest(String p1) {
        return "fallback";
    }


}
