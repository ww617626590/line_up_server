package com.gate_machine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


/**
 * 创建并配置CORS过滤器。
 * 该过滤器允许所有请求头、方法和来源，并且支持跨域请求的凭据。
 *
 * @return CorsWebFilter CORS过滤器实例
 */
@Configuration
public class CorsConfigurationC {
    @Bean
    public CorsWebFilter corsWebFilter() {
// 创建基于URL的CORS配置源
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 创建CORS配置对象并进行设置
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedHeader("*");//允许所有请求头
        corsConfiguration.addAllowedMethod("*"); // 允许所有请求方法
        corsConfiguration.addAllowedOrigin("*"); // 允许跨域请求的凭据

        corsConfiguration.setAllowCredentials(true);


// 将CORS配置注册到URL基础的CORS配置源上，应用到所有路径
        source.registerCorsConfiguration("/**", corsConfiguration);
        // 返回基于上述配置创建的CORS过滤器
        return new CorsWebFilter(source);


    }
}
