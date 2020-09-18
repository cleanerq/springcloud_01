package com.qby.springcloud.controller;

import com.qby.springcloud.entities.CommonResult;
import com.qby.springcloud.entities.Payment;
import com.qby.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeignController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> create(@PathVariable("id") Long id) {
        return paymentService.create(id);
    }

    @PostMapping("/payment/create")
    CommonResult<Payment> create(Payment payment) {
        return paymentService.create(payment);
    }
}
