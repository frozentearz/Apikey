package com.api.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class ApiConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
 
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("APIKey 接口文档")
                .description("本项目可以储存第三方的APIKey，需要时直接访问本项目的API接口；从而避免把APIKey暴露在第三方开源平台（如：github）。因为某些第三方API提供商会在github上检测自家APIKey是否暴露在开源平台，是则对相应的账号进行暂封处理。")
                .termsOfServiceUrl("apikey.fuckby.me")
                .license("")
                .licenseUrl("")
                .version("1.0.0")
                .build();
    }
 
}