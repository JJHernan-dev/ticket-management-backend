package dev.jjhernan.ticketmanagementapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Manejador global de excepciones para la API.
 * Centraliza el tratamiento de errores y devuelve respuestas
 * HTTP coherentes y legibles al cliente.
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja la excepción lanzada cuando un ticket no existe.
     *
     * @param ex excepción TicketNotFoundException
     * @return respuesta HTTP 404 con mensaje de error
     */
    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleTicketNotFound(TicketNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /**
     * Maneja errores de tipo IllegalArgumentException.
     * Se utiliza para errores de lógica o argumentos inválidos.
     *
     * @param ex excepción IllegalArgumentException
     * @return respuesta HTTP 400 con mensaje descriptivo
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Maneja errores de validación producidos por anotaciones
     * como @NotNUll, @NotBlank, etc.
     * @param ex excepción MethodArgumentNotValidException
     * @return respuesta HTTP 400 con los errores por campo
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }
}
