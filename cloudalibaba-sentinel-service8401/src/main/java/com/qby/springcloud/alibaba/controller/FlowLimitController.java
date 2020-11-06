package com.qby.springcloud.alibaba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FlowLimitController {
    @GetMapping("/testA")
    @ResponseBody
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    @ResponseBody
    public String testB() {
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC() {
        System.out.println("testC");
        return "redirect:/testA";
    }
}
