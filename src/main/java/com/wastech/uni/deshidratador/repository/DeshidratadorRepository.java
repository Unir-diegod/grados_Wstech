package com.wastech.uni.deshidratador.repository;

import com.wastech.uni.deshidratador.entity.Deshidratador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository de acceso a datos para la entidad Deshidratador.
 */
@Repository
public interface DeshidratadorRepository extends JpaRepository<Deshidratador, Long> {

    List<Deshidratador> findByArduinoIdArduino(Long idArduino);
}
