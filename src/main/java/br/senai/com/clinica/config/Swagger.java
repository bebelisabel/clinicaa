package br.senai.com.clinica.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Clínica API - Isabel",
        version = "1.0",
        description = "API para o sistema Clinica"
    )
)
public class Swagger {

}
