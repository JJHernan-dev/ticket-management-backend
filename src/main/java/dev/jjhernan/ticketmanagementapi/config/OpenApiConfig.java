package dev.jjhernan.ticketmanagementapi.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de OpenAPI / Swagger para la documentación
 * automática de la Ticket Management API.
 */

@Configuration
public class OpenApiConfig {

    /**
     * Define la configuración principal de OpenAPI que se mostrará
     * en la interfaz Swagger UI.
     *
     * @return configuración personalizada de OpenAPI
     */

    @Bean
    public OpenAPI ticketApiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Ticket Management API")
                        .description("API para gestionar tickets de soporte")
                        .version("1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositorio GitHub")
                        .url("https://github.com/JJHernan-dev/ticket-management-backend"));
    }
}
