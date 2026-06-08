package com.wastech.uni.resultado.service;

import com.wastech.uni.resultado.entity.Resultado;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de servicio para la gestión de resultados de sensores.
 */
public interface ResultadoService {

    List<Resultado> findAll();

    Optional<Resultado> findById(Long id);

    List<Resultado> findBySensor(Long idSensor);

    Resultado save(Resultado resultado);

    void deleteById(Long id);
}
