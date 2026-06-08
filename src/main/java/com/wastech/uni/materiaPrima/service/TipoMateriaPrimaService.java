package com.wastech.uni.materiaPrima.service;

import com.wastech.uni.materiaPrima.entity.TipoMateriaPrima;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de servicio para la gestión de tipos de materia prima.
 */
public interface TipoMateriaPrimaService {

    List<TipoMateriaPrima> findAll();

    Optional<TipoMateriaPrima> findById(Long id);

    TipoMateriaPrima save(TipoMateriaPrima tipoMateriaPrima);

    void deleteById(Long id);
}
