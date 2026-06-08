package com.wastech.uni.arduino.service;

import com.wastech.uni.arduino.entity.Arduino;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de servicio para la gestión de dispositivos Arduino.
 */
public interface ArduinoService {

    List<Arduino> findAll();

    Optional<Arduino> findById(Long id);

    Arduino save(Arduino arduino);

    void deleteById(Long id);

    boolean existsByNombre(String nombre);
}
