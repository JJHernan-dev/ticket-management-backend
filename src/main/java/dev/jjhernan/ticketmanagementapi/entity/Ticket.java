package dev.jjhernan.ticketmanagementapi.entity;

import dev.jjhernan.ticketmanagementapi.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad JPA que representa un ticket de soporte.
 * Se mapea contra la tabla "tickets" en la base de datos.
 */

@Getter
@Setter
@Entity
@Table(name = "tickets")
public class Ticket {

    /**
     * Identificador único del ticket.
     * Se genera automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    /**
     * Título del ticket.
     * Campo obligatorio.
     */
    @Column(nullable = false)
    private String title;

    /**
     * Descripción detallada del problema.
     * Longitud máxima de 1000 caracteres.
     */
    @Column(length = 1000)
    private String description;

    /**
     * Estado actual del ticket.
     * Se persiste como texto (OPEN, IN_PROGRESS, CLOSED).
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus status;

}
