package com.wastech.uni.materiaPrima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Tipos de Materia Prima.
 */
@Controller
@RequestMapping("/tipo-materia-prima")
public class TipoMateriaPrimaController {

    @org.springframework.web.bind.annotation.GetMapping
    public String index() {
        return "tipo-materia-prima/lista";
    }
}
