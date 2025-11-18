package org.example;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot 3.3.0 API Documentation")
                        .version("v1.0")
                        .description("API documentation for the Spring Boot 3.3.0 application")
                        .contact(new Contact().name("Spring boot test").email("supmti@example.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}

