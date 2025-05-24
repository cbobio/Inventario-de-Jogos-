package br.com.carlos.iventario.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Inventário")
                        .description("Documentação da API de Inventário")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Carlos Bóbio")
                                .email("cbobio3@gmail.com")
                        )
                );
    }
}

//// http://localhost:8080/swagger-ui/index.html
/// http://localhost:8080/swagger-ui.html