package dev.jjhernan.ticketmanagementapi.controller;

import dev.jjhernan.ticketmanagementapi.dto.TicketRequestDto;
import dev.jjhernan.ticketmanagementapi.dto.TicketResponseDto;
import dev.jjhernan.ticketmanagementapi.dto.TicketStatusUpdateDto;
import dev.jjhernan.ticketmanagementapi.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Controlador REST encargado de exponer los endpoints
 * para la gestión de tickets de soporte.
 */

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    /**
     * Inyección del servicio de tickets.
     *
     * @param ticketService servicio que contiene la lógica de negocio.
     */

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Obtiene la lista completa de tickets.
     *
     * @return lista de tickets
     */

    @GetMapping
    public List<TicketResponseDto> getAllTickets() {
        return ticketService.getAllTickets();
    }

    /**
     * Obtiene un ticket por identificador.
     *
     * @param id identificador del ticket
     * @return ticket encontrado
     */

    @GetMapping("/{id}")
    public TicketResponseDto getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    /**
     * Actualiza completamente un ticket existente.
     *
     * @param id identificador del ticket
     * @param dto nuevos datos del ticket
     * @return ticket actualizado
     */

    @PutMapping("/{id}")
    public TicketResponseDto updateTicket(
            @PathVariable Long id,
            @Valid @RequestBody TicketRequestDto dto
    ) {
        return ticketService.updateTicket(id, dto);
    }

    /**
     * Elimina un ticket por su identificador.
     *
     * @param id identificador del ticket
     */

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }

    /**
     * Actualiza únicamente el estado de un ticket.
     *
     * @param id identificador del ticket
     * @param dto nuevo estado del ticket
     * @return ticket con el estado actualizado
     */

    @PatchMapping("/{id}/status")
    public TicketResponseDto updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody TicketStatusUpdateDto dto
    ) {
        return ticketService.updateTicketStatus(id, dto);
    }

    /**
     * Crea un nuevo ticket.
     *
     * @param ticketDto datos del ticket a crear
     * @return ticket creado con cabecera Location
     */

    @PostMapping
    public ResponseEntity<TicketResponseDto> createTicket(
            @Valid @RequestBody TicketRequestDto ticketDto
    ) {
        TicketResponseDto created = ticketService.createTicket(ticketDto);

        URI location = URI.create("/api/tickets/" + created.getId());

        return ResponseEntity
                .created(location)
                .body(created);
    }

}
