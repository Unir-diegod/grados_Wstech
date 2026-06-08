package com.wastech.uni.security;

import com.wastech.uni.usuario.entity.Usuario;
import com.wastech.uni.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para cargar los detalles del usuario durante la autenticación de Spring Security.
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar el usuario por nombre de usuario
        Usuario usuario = usuarioRepository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Obtener el rol desde la entidad Perfil asociada
        // Se asume que el nombre del perfil es "ADMINISTRADOR" o "CLIENTE"
        // Spring Security por convención utiliza el prefijo "ROLE_"
        String roleName = "ROLE_" + usuario.getPerfil().getNombre().toUpperCase();
        
        // Retornar el objeto UserDetails de Spring Security
        return new org.springframework.security.core.userdetails.User(
                usuario.getUsuario(),
                usuario.getContrasena(), // La contraseña está hasheada
                Collections.singletonList(new SimpleGrantedAuthority(roleName))
        );
    }
}
