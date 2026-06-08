package com.wastech.uni.arduino.repository;

import com.wastech.uni.arduino.entity.Arduino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository de acceso a datos para la entidad Arduino.
 */
@Repository
public interface ArduinoRepository extends JpaRepository<Arduino, Long> {

    Optional<Arduino> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
