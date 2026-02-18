package dev.jjhernan.ticketmanagementapi.exception;

/**
 * Excepción personalizada que se lanza cuando
 * no se encuentra un ticket con el identificador proporcionado.
 *
 * Se utiliza principalmente en la capa de servicio
 * y es manejada por el GlobalExceptionHandler para devolver
 * una respuesta HTTP 404 (Not Found).
 */
public class TicketNotFoundException extends RuntimeException {

    /**
     * Crea una nueva excepción indicando que no existe
     * un ticket con el ID especificado.
     *
     * @param id identificador del ticket no encontrado
     */
    public TicketNotFoundException(Long id) {
        super("Ticket no encontrado con id: " + id);
    }
}