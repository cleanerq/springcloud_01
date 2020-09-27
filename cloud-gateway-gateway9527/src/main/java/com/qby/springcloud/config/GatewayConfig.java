package com.qby.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类配置-路由
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator getRouteLocatorGuonei(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_rote_guonei", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        routes.route("path_rote_guoji", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
