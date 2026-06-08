package com.wastech.uni.usuario.controller;

import com.wastech.uni.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Usuarios.
 * Maneja las solicitudes HTTP relacionadas con la gestión de usuarios.
 *
 * TODO (sprint gestión de usuarios):
 *  - GET  /usuarios        → listar todos los usuarios
 *  - GET  /usuarios/{id}   → ver detalle de un usuario
 *  - GET  /usuarios/nuevo  → formulario de creación
 *  - POST /usuarios        → crear usuario
 *  - GET  /usuarios/{id}/editar → formulario de edición
 *  - POST /usuarios/{id}   → actualizar usuario
 *  - POST /usuarios/{id}/eliminar → eliminar usuario
 */
@Controller
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    // TODO: implementar endpoints en el sprint de gestión de usuarios
}
