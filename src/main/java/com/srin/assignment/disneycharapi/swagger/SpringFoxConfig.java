package com.srin.assignment.disneycharapi.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.srin.assignment.disneycharapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Disney Character Application(disney-char-api)",
                "Aplikasi for SRIN assignment",
                "disney-char-api-0.0.1-SNAPSHOT",
                "Term Of Service",
                new Contact("Gilang Widianto Aldiasnyah","","gilangwidianto117@gmail.com"),
                "Apache License",
                "https://www.apache.org/licenses/LICENSE-2.0https://www.apache.org/licenses/LICENSE-2.0",
                Collections.emptyList()
        );
        return apiInfo;
    }
}
