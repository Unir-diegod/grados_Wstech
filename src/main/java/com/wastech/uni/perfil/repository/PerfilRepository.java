package com.wastech.uni.perfil.repository;

import com.wastech.uni.perfil.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository de acceso a datos para la entidad Perfil.
 * Extiende JpaRepository para operaciones CRUD básicas.
 */
@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Optional<Perfil> findByNombre(String nombre);

    Optional<Perfil> findFirstByNombreOrderByIdperfilAsc(String nombre);

    boolean existsByNombre(String nombre);
}
