package com.qby.springcloud.controller;

import com.qby.springcloud.entities.CommonResult;
import com.qby.springcloud.entities.Payment;
import com.qby.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int flg = paymentService.create(payment);

        log.info("插入结果：" + flg);
        if (flg > 0) {
            return new CommonResult(200, "插入数据库成功 对对对 serverPort:" + serverPort, flg);
        } else {
            return new CommonResult(444, "插入数据库失败", flg);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        log.info("查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功 222 serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID：" + id, payment);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        // 获取服务清单列表
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("***** element:" + element);
        }
        // 根据服务名称获取服务实例集合
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}
