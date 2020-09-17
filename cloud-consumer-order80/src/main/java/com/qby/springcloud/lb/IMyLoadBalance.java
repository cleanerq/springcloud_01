package com.qby.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface IMyLoadBalance {
    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
