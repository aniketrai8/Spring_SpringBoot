package com.example.studentdatajpa.controller;

import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customConfig() {
        return new OpenAPI()
                 .info(
                         new Info().title("StudentDatabase API")
                         .description("By Aniket")
                 )
        .servers(Arrays.asList(new Server().url("https://localhost:8080").description("local"),
                new Server().url("https://localhost8082").description("Live") ));
    }
}
