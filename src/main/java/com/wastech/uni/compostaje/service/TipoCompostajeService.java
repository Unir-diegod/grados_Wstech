package com.wastech.uni.compostaje.service;

import com.wastech.uni.compostaje.entity.TipoCompostaje;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de servicio para la gestión de tipos de compostaje.
 */
public interface TipoCompostajeService {

    List<TipoCompostaje> findAll();

    Optional<TipoCompostaje> findById(Long id);

    TipoCompostaje save(TipoCompostaje tipoCompostaje);

    void deleteById(Long id);
}
