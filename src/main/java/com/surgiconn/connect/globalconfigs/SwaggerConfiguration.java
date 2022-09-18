package com.surgiconn.connect.globalconfigs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)

                .apiInfo(info())

                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.surgiconn.connect"))
                .paths(PathSelectors.regex("/api/v1/.*"))
                .build()
                ;
    }

    private ApiInfo info() {

        return new ApiInfo(
                "HOCore",
                "HOCore API Documentation",
                "v1",
                "http://localhost:8098/api/v1/",
                new Contact("Horecami Inc", "https://horecami.com", "mail@horecami.com"),
                "Horecami License",
                "https://horecami.com/lisences"
        );
    }

    private ApiKey apiKey() {
        return new ApiKey("API-KEY", "API-KEY", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope authorizationScope = new springfox.documentation.service.AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("API-KEY", authorizationScopes));
    }
}