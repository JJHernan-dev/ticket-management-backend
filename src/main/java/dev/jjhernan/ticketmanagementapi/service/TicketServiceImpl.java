package dev.jjhernan.ticketmanagementapi.service;

import dev.jjhernan.ticketmanagementapi.dto.TicketRequestDto;
import dev.jjhernan.ticketmanagementapi.dto.TicketResponseDto;
import dev.jjhernan.ticketmanagementapi.dto.TicketStatusUpdateDto;
import dev.jjhernan.ticketmanagementapi.entity.Ticket;
import dev.jjhernan.ticketmanagementapi.exception.TicketNotFoundException;
import dev.jjhernan.ticketmanagementapi.mapper.TicketMapper;
import dev.jjhernan.ticketmanagementapi.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio de tickets.
 *
 * Contiene la lógica de negocio de la aplicación y se encarga
 * de coordinar el accceso a la base de datos a través del repositorio,
 * así como de transformar entidades en DTOs y viceversa.
 */
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    /**
     * Inyección de dependencias mediante constructor.
     *
     * @param ticketRepository repositorio de tickets
     */
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    /**
     * Obtiene todos los tickets almacenados en la base de datos.
     *
     * @return lista de tickets en formato DTO
     */
    @Override
    public List<TicketResponseDto> getAllTickets() {
        return ticketRepository.findAll()
                .stream()
                .map(TicketMapper::toResponse)
                .toList();
    }

    /**
     * Crea un nuevo ticket.
     *
     * Convierte el DTO de entrada en una entidad,
     * la guarda en la base de datos y devuelve el resutlado
     * en formato DTO.
     *
     * @param ticketDto datos del ticket a crear
     * @return ticket creado
     */
    @Override
    public TicketResponseDto createTicket(TicketRequestDto ticketDto) {
        Ticket ticket = TicketMapper.toEntity(ticketDto);
        Ticket saved = ticketRepository.save(ticket);
        return TicketMapper.toResponse(saved);
    }

    /**
     * Obtiene un ticket por su identificador.
     *
     * @param id identificador del ticket
     * @return ticket encontrado
     * @throws TicketNotFoundException si el ticket no existe
     */
    @Override
    public TicketResponseDto getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        return TicketMapper.toResponse(ticket);
    }

    /**
     * Actualiza completamente un ticket existente.
     *
     * La validación de los datos se realiza previamente
     * en el controlador mediante @valid.
     *
     * @param id identificador del ticket
     * @param ticketDto nuevos datos del ticket
     * @return ticket actualizado
     */
    @Override
    public TicketResponseDto updateTicket(Long id, TicketRequestDto ticketDto) {
        Ticket existing = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        existing.setTitle(ticketDto.getTitle());
        existing.setDescription(ticketDto.getDescription());
        existing.setStatus(ticketDto.getStatus());

        Ticket updated = ticketRepository.save(existing);
        return TicketMapper.toResponse(updated);
    }

    /**
     * Elimina un ticket por su identificador.
     *
     * @param id identificador del ticket a eliminar
     * @throws TicketNotFoundException si el ticket no existe
     */
    @Override
    public void deleteTicket(Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new TicketNotFoundException(id);
        }
        ticketRepository.deleteById(id);
    }

    /**
     * Actualiza únicamente el estado de un ticket.
     *
     * @param id identificador del ticket
     * @param dto nuevo estado del ticket
     * @return ticket con el estado actualizado
     */
    @Override
    public TicketResponseDto updateTicketStatus(Long id, TicketStatusUpdateDto dto) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        ticket.setStatus(dto.getStatus());

        Ticket updated = ticketRepository.save(ticket);
        return TicketMapper.toResponse(updated);
    }


}