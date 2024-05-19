package com.gate_machine.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 可以根据需要调整路径
                .allowedOrigins("http://localhost:8080") // 替换为你的前端应用的URL
                .allowedMethods("*") // 允许所有HTTP方法
                .allowedHeaders("*") // 允许所有HTTP头部
                .allowCredentials(true); // 允许携带身份凭证（cookies）
    }
}
