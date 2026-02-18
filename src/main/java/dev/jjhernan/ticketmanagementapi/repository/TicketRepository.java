package dev.jjhernan.ticketmanagementapi.repository;

import dev.jjhernan.ticketmanagementapi.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad Ticket.
 *
 * Proporciona automáticamente operaciones CRUD básicas
 * gracias a JpaRepository, como:
 * - buscar por id
 * - listar todos los tickets
 * - crear y actualizar tickets
 * - eliminar tickets
 *
 * No es necesario implementar métodos manualmente
 * mientras las operaciones estándar sean suficientes.
 */
public interface TicketRepository extends JpaRepository<Ticket, Long>{

    // Métodos personalizados podrían añadirse aquí si fueran necesarios

}
