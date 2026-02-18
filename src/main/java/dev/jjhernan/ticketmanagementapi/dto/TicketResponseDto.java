package dev.jjhernan.ticketmanagementapi.dto;

import dev.jjhernan.ticketmanagementapi.enums.TicketStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO utilizado para resolver la información de un ticket al cliente.
 * Representa la respuesta de la API.
 */

@Getter
@Setter
public class TicketResponseDto {
    private Long id;
    private String title;
    private String description;
    private TicketStatus status;


}
