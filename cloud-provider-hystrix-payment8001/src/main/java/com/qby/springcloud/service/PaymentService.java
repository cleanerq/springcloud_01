package com.qby.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    /**
     * 正常访问 OK
     *
     * @param id
     * @return
     */
    public String paymentInfoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfoOk,id:" + id + "@@@@@";
    }

    public String paymentInfoTimeOut(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfoOk,id:" + id + "@@@@@";
    }
}
