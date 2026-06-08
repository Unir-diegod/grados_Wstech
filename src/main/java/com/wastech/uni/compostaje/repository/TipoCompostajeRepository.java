package com.wastech.uni.compostaje.repository;

import com.wastech.uni.compostaje.entity.TipoCompostaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository de acceso a datos para la entidad TipoCompostaje.
 */
@Repository
public interface TipoCompostajeRepository extends JpaRepository<TipoCompostaje, Long> {
}
