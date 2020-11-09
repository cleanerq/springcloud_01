package com.qby.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    @ResponseBody
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    @ResponseBody
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + " testB ");
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC() {
        System.out.println("testC");
        return "redirect:/testA";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "------testD";
    }

}
