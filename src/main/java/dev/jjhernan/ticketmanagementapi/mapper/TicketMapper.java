package dev.jjhernan.ticketmanagementapi.mapper;

import dev.jjhernan.ticketmanagementapi.dto.TicketRequestDto;
import dev.jjhernan.ticketmanagementapi.dto.TicketResponseDto;
import dev.jjhernan.ticketmanagementapi.entity.Ticket;

/**
 * Clase encargada de convertir entre entidades y DTOs relacionados
 * con la entidad Ticket.
 *
 * Centraliza la lógica de mapeo para evitar duplicación de código
 * en controladores o servicios.
 */
public class TicketMapper {

    /**
     * Convierte un TicketRequestDto en una entidades Ticket.
     * Se utiliza principalmente al crear o actualizar tickets.
     *
     * @param dto datos recibidos desde el cliente
     * @return entidad Ticket lista para persistir
     */
    public static Ticket toEntity(TicketRequestDto dto) {
        Ticket ticket = new Ticket();
        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setStatus(dto.getStatus());
        return ticket;
    }

    /**
     * Convierte una entidad Ticket en un TicketResponseDto
     * Se utiliza para devolver información al cliente.
     *
     * @param ticket entidad obtenida de la base de datos
     * @return DTO con los datos expuestos al cliente
     */
    public static TicketResponseDto toResponse(Ticket ticket) {
        TicketResponseDto dto = new TicketResponseDto();
        dto.setId(ticket.getId());
        dto.setTitle(ticket.getTitle());
        dto.setDescription(ticket.getDescription());
        dto.setStatus(ticket.getStatus());
        return dto;
    }
}