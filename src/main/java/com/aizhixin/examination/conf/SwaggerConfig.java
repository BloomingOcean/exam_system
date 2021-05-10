package com.aizhixin.examination.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@SuppressWarnings("unchecked")
public class SwaggerConfig {
	@Value("${sys.version}")
	private String systemPublish;
	
	
	@Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("考试相关API")
                .pathMapping("/")
                .select()
                .paths(or(regex("/v1/open/test/.*")))//过滤的接口
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("考试相关API")
                        .version(systemPublish)
                        .build());
    }
	
	@Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户信息相关API")
                .pathMapping("/")
                .select()
                .paths(or(regex("/v1/open/user/.*")))//过滤的接口
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("用户信息相关API")
                        .version(systemPublish)
                        .build());
	}
}