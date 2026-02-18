package dev.jjhernan.ticketmanagementapi.service;

import dev.jjhernan.ticketmanagementapi.dto.TicketRequestDto;
import dev.jjhernan.ticketmanagementapi.dto.TicketResponseDto;
import dev.jjhernan.ticketmanagementapi.dto.TicketStatusUpdateDto;

import java.util.List;

/**
 * Interfaz del servicio de tickets.
 *
 * Define la lógica de negocio de la aplicación y actúa como
 * intermediario entre el controlador (controller) y la capa
 * de persistencia (repository).
 *
 * El uso de una interfaz permite desacoplar la implementación
 * concreta del servicio y facilita futuras mejoras o test.
 */

public interface TicketService {

    /**
     * Obtiene la lista completa de tickets.
     *
     * @return lista de tickets en formato de respuesta
     */
    List<TicketResponseDto> getAllTickets();

    /**
     * Crea un nuevo ticket a partir de los datos recibidos.
     *
     * @param ticketDto datos del ticket a crear
     * @return ticket creado
     */
    TicketResponseDto createTicket(TicketRequestDto ticketDto);

    /**
     * Obtiene un ticket por su identificador.
     *
     * @param id identificador del ticket
     * @return ticket encontrado
     */
    TicketResponseDto getTicketById(Long id);

    /**
     * Actualiza completamente un ticket existente.
     *
     * @param id identificador del ticket
     * @param ticketDto nuevos datos del ticket
     * @return ticket actualizado
     */
    TicketResponseDto updateTicket(Long id, TicketRequestDto ticketDto);

    /**
     * Actualiza únicamente el estado de un ticket.
     *
     * @param id identificador del ticket
     * @param dto nuevo estado del ticket
     * @return ticket con el estado actualizado
     */
    TicketResponseDto updateTicketStatus(Long id, TicketStatusUpdateDto dto);

    /**
     * Elimina un ticket por su identificador.
     *
     * @param id identificador del ticket a eliminar
     */
    void deleteTicket(Long id);

}