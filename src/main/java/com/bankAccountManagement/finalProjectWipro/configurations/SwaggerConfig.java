package com.bankAccountManagement.finalProjectWipro.configurations;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.bankAccountManagement.finalProjectWipro.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Booster Bank API",
				"REST API of a bank with two types of accounts (current account and special account).", "1.0", "",
				new Contact("", "", ""), "MIT License",
				"https://github.com/LeoMSSilva/finalProjectWipro-bankAccountManagement/blob/main/LICENSE",
				new ArrayList<>());
	}

}