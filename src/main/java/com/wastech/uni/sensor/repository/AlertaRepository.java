package com.wastech.uni.sensor.repository;

import com.wastech.uni.sensor.entity.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    List<Alerta> findTop10ByOrderByFechaDesc();
}
