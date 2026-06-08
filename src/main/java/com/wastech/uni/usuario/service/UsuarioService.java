package com.wastech.uni.usuario.service;

import com.wastech.uni.usuario.entity.Usuario;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de servicio para la gestión de Usuarios.
 * Define las operaciones disponibles para la capa de presentación.
 *
 * TODO (sprints futuros):
 *  - registrarUsuario(dto)
 *  - cambiarContrasena(id, nuevaContrasena)
 *  - activar/desactivarUsuario(id)
 */
public interface UsuarioService {

    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByUsuario(String username);

    Usuario save(Usuario usuario);

    void deleteById(Long id);

    boolean existsByUsuario(String username);
}
