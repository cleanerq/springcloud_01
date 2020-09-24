package com.qby.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService----- paymentInfo_OK fall back ::T_T::";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService----- paymentInfo_TimeOut fall back ::T_T::";
    }
}
