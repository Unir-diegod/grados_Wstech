package com.wastech.uni.resultado.repository;

import com.wastech.uni.resultado.entity.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository de acceso a datos para la entidad Resultado.
 */
@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {

    List<Resultado> findBySensorIdSensor(Long idSensor);
}
