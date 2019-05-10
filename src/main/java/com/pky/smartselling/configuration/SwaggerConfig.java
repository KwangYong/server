package com.pky.smartselling.configuration;

import com.pky.smartselling.controller.HashId;
import com.pky.smartselling.domain.employee.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
@EnableSwagger2

public class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER = "X-Authorization-Firebase";
    public static final String DEFAULT_INCLUDE_PATTERN = ".*/api/.*";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(Arrays.asList(apiKey()))
                .securityContexts(Arrays.asList(securityContext()))
                .ignoredParameterTypes(AuthenticationPrincipal.class)
                .ignoredParameterTypes(Employee.class)
                .ignoredParameterTypes(HashId.class)
                .genericModelSubstitutes(Optional.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pky.smartselling.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(
                new SecurityReference("JWT", authorizationScopes));
    }

}