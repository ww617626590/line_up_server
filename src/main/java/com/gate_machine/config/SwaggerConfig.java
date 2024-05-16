package com.gate_machine.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        StringBuilder desc = new StringBuilder();
        desc.append("后台管理系统接口文档");
        return new OpenAPI()
                .info(new Info()
                        .title("后台管理系统 - 接口文档")
                        .description(desc.toString())
                        .version("V1.0")
                        .contact(new Contact().name("zhonglm"))
                );
    }

    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("后台接口")
                .packagesToScan("com.gate_machine.controller")
                .build();
    }


}
