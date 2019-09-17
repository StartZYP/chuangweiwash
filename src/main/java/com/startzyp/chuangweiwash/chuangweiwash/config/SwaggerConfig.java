package com.startzyp.chuangweiwash.chuangweiwash.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean swaggerShow;

    @Bean
    public Docket LoginApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerShow)
                .apiInfo(LoginApiInfo())
                .groupName("游客登录")
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.startzyp.chuangweiwash.chuangweiwash.controller.logincontroller"))
                .paths(PathSelectors.any())
                .build();
    }


    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerShow)
                .apiInfo(userApiInfo())
                .groupName("用户组")
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.startzyp.chuangweiwash.chuangweiwash.controller.usercontroller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerShow)
                .apiInfo(adminApiInfo())
                .groupName("管理组")
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.startzyp.chuangweiwash.chuangweiwash.controller.admincontroller"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo LoginApiInfo() {
        return new ApiInfoBuilder()
                .title("洗衣机开启系统游客登录Api")
                .description("创维漏洞User API 1.0 操作文档")
                //服务条款网址
                .termsOfServiceUrl("http://blog.ipedg.com/")
                .version("1.0")
                .contact(new Contact("漏洞详解文章", "http://blog.ipedg.com/", "codehacker886@gmail.com"))
                .build();
    }

    private ApiInfo userApiInfo() {
        return new ApiInfoBuilder()
                .title("洗衣机开启系统UserApi")
                .description("创维漏洞User API 1.0 操作文档")
                //服务条款网址
                .termsOfServiceUrl("http://blog.ipedg.com/")
                .version("1.0")
                .contact(new Contact("漏洞详解文章", "http://blog.ipedg.com/", "codehacker886@gmail.com"))
                .build();
    }

    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("洗衣机开启系统AdminApi")
                .description("创维漏洞User API 1.0 操作文档")
                //服务条款网址
                .termsOfServiceUrl("http://blog.ipedg.com/")
                .version("1.0")
                .contact(new Contact("漏洞详解文章", "http://blog.ipedg.com/", "codehacker886@gmail.com"))
                .build();
    }
}
