package dev.jjhernan.ticketmanagementapi.dto;

import dev.jjhernan.ticketmanagementapi.enums.TicketStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO utilizado para actualizar únicamente el estado de un ticket.
 * Se emplea en operaciones PATCH.
 */

@Getter
@Setter

public class TicketStatusUpdateDto {

    /**
     * Nuevo estado que se asignará al ticket.
     */
    @NotNull(message = "El estado es obligatorio")
    private TicketStatus status;
}
