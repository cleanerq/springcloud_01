package com.qby.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.qby.springcloud.alibaba.dao"})
public class MyBatisConfig {

}
