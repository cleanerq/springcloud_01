package com.qby.springcloud.service;

import com.qby.springcloud.entities.CommonResult;
import com.qby.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> create(@PathVariable("id") Long id);

    @PostMapping("/payment/create")
    CommonResult<Payment> create(Payment payment);
}
