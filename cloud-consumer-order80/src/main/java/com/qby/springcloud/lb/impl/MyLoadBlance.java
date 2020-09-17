package com.qby.springcloud.lb.impl;

import com.qby.springcloud.lb.IMyLoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLoadBlance implements IMyLoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current = 0;
        int next = 0;
        do {
            current = atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("第几次访问 next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int andIncrement = getAndIncrement();
        int index = andIncrement % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
