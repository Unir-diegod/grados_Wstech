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
import org.springframework.data.jpa.repository.EntityGraph;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Override
    @EntityGraph(attributePaths = {"perfil", "cliente"})
    java.util.List<Usuario> findAll();

    Optional<Usuario> findByUsuario(String usuario);

    Optional<Usuario> findByClienteCorreo(String correo);

    Optional<Usuario> findFirstByClienteCorreoOrderByIdusuarioAsc(String correo);

    boolean existsByClienteCorreo(String correo);

    boolean existsByUsuario(String usuario);
    
    // Para validación en edición: existe usuario que no sea este ID
    boolean existsByUsuarioAndIdusuarioNot(String usuario, Long idusuario);

    // Para la vista de búsqueda
    @EntityGraph(attributePaths = {"perfil", "cliente"})
    java.util.List<Usuario> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCaseOrUsuarioContainingIgnoreCase(
            String nombre, String apellido, String usuarioBusqueda);
}
