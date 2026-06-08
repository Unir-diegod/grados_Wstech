package com.wastech.uni.sensor.service;

import com.wastech.uni.sensor.entity.TipoSensor;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de servicio para la gestión de tipos de sensor.
 */
public interface TipoSensorService {

    List<TipoSensor> findAll();

    Optional<TipoSensor> findById(Long id);

    TipoSensor save(TipoSensor tipoSensor);

    void deleteById(Long id);
}
