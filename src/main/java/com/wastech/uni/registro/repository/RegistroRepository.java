package com.wastech.uni.registro.repository;

import com.wastech.uni.registro.entity.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository de acceso a datos para la entidad Registro.
 */
@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {

    List<Registro> findByEstado(String estado);

    List<Registro> findByDeshidratadorIdDeshidratador(Long idDeshidratador);
}
