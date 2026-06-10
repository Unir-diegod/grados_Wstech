package com.wastech.uni.security.controller;

import com.wastech.uni.security.JwtService;
import com.wastech.uni.usuario.entity.Usuario;
import com.wastech.uni.usuario.repository.UsuarioRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class ApiAuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (username == null || password == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Faltan parámetros de credenciales"));
        }

        Usuario usuario = usuarioRepository.findByUsuario(username)
                .orElse(null);

        if (usuario == null || !passwordEncoder.matches(password, usuario.getContrasena())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Credenciales incorrectas"));
        }

        String role = usuario.getPerfil() != null ? usuario.getPerfil().getNombre() : "CLIENTE";
        String token = jwtService.generateToken(username, role);

        return ResponseEntity.ok(Map.of(
                "token", token,
                "type", "Bearer",
                "username", username,
                "role", role
        ));
    }

    @Data
    public static class LoginRequest {
        private String username;
        private String password;
    }
}
