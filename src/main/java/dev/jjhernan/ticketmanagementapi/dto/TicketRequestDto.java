package dev.jjhernan.ticketmanagementapi.dto;

import dev.jjhernan.ticketmanagementapi.enums.TicketStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO utilizado para la creación y actualización de tickets.
 * Representa los datos que el cliente envía a la API.
 */
@Getter
@Setter
public class TicketRequestDto {

    /**
     * Título del ticket.
     */
    @NotBlank(message = "El título es obligatorio")
    @Schema(description = "Título del ticket", example = "Error al iniciar sesión")
    private String title;

    /**
     * Descripción detallada del problema o solicitud.
     */
    @Schema(description = "Descripción detallada del ticket", example = "El usuario no puede iniciar sesión en la aplicación")
    private String description;

    /**
     * Estado actual del ticket.
     */
    @NotNull(message = "El estado es obligatorio")
    @Schema(description = "Estado del ticket", example = "OPEN")
    private TicketStatus status;
}