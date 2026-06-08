package com.wastech.uni.materiaPrima.controller;

import com.wastech.uni.materiaPrima.service.TipoMateriaPrimaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Tipos de Materia Prima.
 */
@Controller
@RequestMapping("/tipo-materia-prima")
@RequiredArgsConstructor
public class TipoMateriaPrimaController {

    private final TipoMateriaPrimaService tipoMateriaPrimaService;
}
