/*
 *  
 * Created on Oct 16, 2016
 *
 */
package com.doengine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author SumeetS
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket parserApis() {
	return new Docket(DocumentationType.SWAGGER_2).groupName("bot-apis").apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
		.paths(botApiPaths()).build();
    }

    /**
     * @return
     */
    private Predicate<String> botApiPaths() {
	return PathSelectors.regex("/bot/.*");
    }
    
    private ApiInfo apiInfo() {
	ApiInfo apiInfo = new ApiInfoBuilder().title("doengine").description("doengine APIs").contact("sumeetmi2@gmail.com")
		.license("doengine API License").licenseUrl("doengine API License URL").termsOfServiceUrl("doengine Terms of Service URL")
		.version("1.0.0").build();
	return apiInfo;
    }
}

