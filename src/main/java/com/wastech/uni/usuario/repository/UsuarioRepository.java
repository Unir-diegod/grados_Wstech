package com.wastech.uni.usuario.repository;

import com.wastech.uni.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository de acceso a datos para la entidad Usuario.
 * Extiende JpaRepository para operaciones CRUD básicas.
 *
 * TODO (sprint login):
 *  - findByUsuario(String username) para autenticación con Spring Security
 *  - findByClienteCedula(String cedula) para búsqueda por cliente
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsuario(String usuario);

    boolean existsByUsuario(String usuario);
}
