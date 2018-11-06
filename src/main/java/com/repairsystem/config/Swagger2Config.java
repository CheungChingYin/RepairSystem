package com.repairsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/11/4
 * @time 10:39
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        // 为swagger添加header参数可供输入
        ParameterBuilder userTokenHeader = new ParameterBuilder();
        ParameterBuilder userIdHeader = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        userTokenHeader.name("headerUserToken").description("userToken")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        userIdHeader.name("headerUserId").description("userId")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(userTokenHeader.build());
        pars.add(userIdHeader.build());

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.repairsystem.web.controller"))
                .paths(PathSelectors.any()).build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("机房报修系统后台API")
                // 设置联系人
                .contact(new Contact("CheungChingYin-张正贤", "https://blog.csdn.net/qq_33596978", "CheungChingYin@outlook.com"))
                // 描述
                .description("欢迎访问机房报修系统接口文档")
                // 定义版本号
                .version("1.0").license("MIT").build();
    }

}
