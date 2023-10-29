package com.china.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket desertsApi1() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo("这不得起飞——Swagger3.0", "1.0"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.china.basic.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("人员信息")
                .enable(true);
    }

//
    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://ip:port/swagger-ui.html
     *
     * @return
     */
    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfoBuilder()
                .title(title)
                .description("这不得起飞接口测试页面")
                .contact(new Contact("GMS", "https://blog.csdn.net/weixin_44924882?spm=1011.2415.3001.5343", "1457205312@qq.com"))
                .termsOfServiceUrl("https://www.zybuluo.com/mdeditor#2281023-full-reader")
                .version(version)
                .build();
    }
}
