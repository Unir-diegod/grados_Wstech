package com.wastech.uni.exception;

/**
 * Excepción lanzada cuando un recurso solicitado no existe en la base de datos.
 * Resulta en una respuesta HTTP 404 Not Found.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resource, String field, Object value) {
        super(String.format("%s no encontrado con %s: '%s'", resource, field, value));
    }
}
