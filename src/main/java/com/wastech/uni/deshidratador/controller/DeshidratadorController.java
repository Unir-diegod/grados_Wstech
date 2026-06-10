package com.wastech.uni.deshidratador.controller;

import com.wastech.uni.deshidratador.service.DeshidratadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Deshidratadores.
 */
@Controller
@RequestMapping("/deshidratadores")
@RequiredArgsConstructor
public class DeshidratadorController {

    private final DeshidratadorService deshidratadorService;

    @org.springframework.web.bind.annotation.GetMapping
    public String index() {
        return "en-construccion";
    }
}
