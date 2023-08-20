package com.example.traveltothefuturebe.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI flightToTheFutureOpenApi(){
        return new OpenAPI()
                .info(new Info().title("Travel To The Future")
                        .description("Travel To The Future Api Docs")
                        .version("1"));
    }
}
