package com.example.demo.swagger;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
@Configuration
@EnableSwagger2
public class SwaggerTest {

	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Sreenivas").apiInfo(apiInfo()).select()
				.paths(regex("/api.*")).build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Rest Api calls").description("Sample documentaion to generate documentation for Rest Api calls")
				.termsOfServiceUrl("https://www.youtube.com/watch?v=2bt11jYIp6E&list=PLVz2XdJiJQxw-jVLpBfVn2yqjvA1Ycceq&index=11")
				.license("Sreenivas").licenseUrl("https://www.youtube.com/watch?v=2bt11jYIp6E&list=PLVz2XdJiJQxw-jVLpBfVn2yqjvA1Ycceq&index=11")
				.version("1.0").build();
	}
}
