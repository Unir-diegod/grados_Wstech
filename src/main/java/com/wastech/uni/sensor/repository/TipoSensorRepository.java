package com.wastech.uni.sensor.repository;

import com.wastech.uni.sensor.entity.TipoSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository de acceso a datos para la entidad TipoSensor.
 */
@Repository
public interface TipoSensorRepository extends JpaRepository<TipoSensor, Long> {
}
