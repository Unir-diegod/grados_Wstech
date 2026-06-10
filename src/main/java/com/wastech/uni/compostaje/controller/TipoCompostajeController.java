package com.wastech.uni.compostaje.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Tipos de Compostaje.
 */
@Controller
@RequestMapping("/tipo-compostaje")
public class TipoCompostajeController {

    @org.springframework.web.bind.annotation.GetMapping
    public String index() {
        return "tipo-compostaje/lista";
    }
}
