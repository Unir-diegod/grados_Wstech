package com.wastech.uni.sensor.service;

import com.wastech.uni.sensor.entity.Sensores;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de servicio para la gestión de sensores.
 * TODO (sprint IoT): agregar procesamiento de lecturas en tiempo real.
 */
public interface SensoresService {

    List<Sensores> findAll();

    Optional<Sensores> findById(Long id);

    List<Sensores> findByArduino(Long idArduino);

    List<Sensores> findByTipoSensor(Long idTipoSensor);

    Sensores save(Sensores sensor);

    void deleteById(Long id);
}
