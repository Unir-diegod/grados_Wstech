package com.wastech.uni.exception;

/**
 * Excepción lanzada cuando se viola una regla de negocio del dominio.
 * Resulta en una respuesta HTTP 400 Bad Request.
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
