package com.wastech.uni.materiaPrima.repository;

import com.wastech.uni.materiaPrima.entity.TipoMateriaPrima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository de acceso a datos para la entidad TipoMateriaPrima.
 */
@Repository
public interface TipoMateriaPrimaRepository extends JpaRepository<TipoMateriaPrima, Long> {
}
