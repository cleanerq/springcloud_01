package com.qby.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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
}
