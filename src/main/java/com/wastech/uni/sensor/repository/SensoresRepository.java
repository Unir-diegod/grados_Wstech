package com.wastech.uni.sensor.repository;

import com.wastech.uni.sensor.entity.Sensores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository de acceso a datos para la entidad Sensores.
 */
@Repository
public interface SensoresRepository extends JpaRepository<Sensores, Long> {

    List<Sensores> findByArduinoIdArduino(Long idArduino);

    List<Sensores> findByTipoSensorIdTipoSensor(Long idTipoSensor);
}
