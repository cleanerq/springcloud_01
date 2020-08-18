package com.qby.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.qby.springcloud.entities.CommonResult;
import com.qby.springcloud.entities.Payment;
import com.qby.springcloud.service.PaymentService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int flg = paymentService.create(payment);

        log.info("插入结果：" + flg);
        if (flg > 0) {
            return new CommonResult(200, "插入数据库成功", flg);
        } else {
            return new CommonResult(444, "插入数据库失败", flg);
        }
    }

    @GetMapping("/payment/create/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        log.info("查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID：" + id, payment);
        }
    }
}