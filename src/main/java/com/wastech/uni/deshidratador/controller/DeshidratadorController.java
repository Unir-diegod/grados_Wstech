package com.wastech.uni.deshidratador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Deshidratadores.
 */
@Controller
@RequestMapping("/deshidratadores")
public class DeshidratadorController {

    @org.springframework.web.bind.annotation.GetMapping
    public String index() {
        return "deshidratadores/lista";
    }

    @org.springframework.web.bind.annotation.GetMapping("/nuevo")
    public String nuevo() {
        return "deshidratadores/formulario";
    }
}
