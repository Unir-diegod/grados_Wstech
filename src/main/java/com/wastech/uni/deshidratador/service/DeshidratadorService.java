package com.wastech.uni.deshidratador.service;

import com.wastech.uni.deshidratador.entity.Deshidratador;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de servicio para la gestión de deshidratadores.
 */
public interface DeshidratadorService {

    List<Deshidratador> findAll();

    Optional<Deshidratador> findById(Long id);

    List<Deshidratador> findByArduino(Long idArduino);

    Deshidratador save(Deshidratador deshidratador);

    void deleteById(Long id);
}
