package com.wastech.uni.usuario.service;

import com.wastech.uni.usuario.dto.UsuarioDTO;
import com.wastech.uni.usuario.entity.Usuario;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de servicio para la gestión de Usuarios.
 */
public interface UsuarioService {

    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    List<Usuario> findByNombreOrUsuario(String search);

    Optional<Usuario> findByUsuario(String username);

    Usuario save(UsuarioDTO dto);

    Usuario update(Long id, UsuarioDTO dto);

    void deleteById(Long id);

    boolean existsByUsuario(String username);

    boolean existsByUsuario(String username);
}
