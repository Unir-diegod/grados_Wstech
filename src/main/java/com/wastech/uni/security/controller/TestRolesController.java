package com.wastech.uni.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST temporal para verificar la correcta asignación de permisos
 * por roles (ADMINISTRADOR y CLIENTE).
 */
@RestController
@RequestMapping
public class TestRolesController {

    @GetMapping("/admin/test")
    public String adminTest() {
        return "¡Hola! Si ves esto, tienes el rol ADMINISTRADOR.";
    }

    @GetMapping("/cliente/test")
    public String clienteTest() {
        return "¡Hola! Si ves esto, tienes el rol CLIENTE (o ADMINISTRADOR, ya que ambos pueden entrar aquí).";
    }
}
