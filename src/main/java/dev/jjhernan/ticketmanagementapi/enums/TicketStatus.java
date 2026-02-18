package dev.jjhernan.ticketmanagementapi.enums;

/**
 * Enum que representa los posibles estados de un ticket de soporte.
 */
public enum TicketStatus {

    /**
     * Ticket recién creado y pendiente de ser atendido.
     */
    OPEN,

    /**
     * Ticket que está siendo gestionado o revisado.
     */
    IN_PROGRESS,

    /**
     * Ticket cerrado o resuelto.
     */
    CLOSED
}
