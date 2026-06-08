package com.wastech.uni.compostaje.controller;

import com.wastech.uni.compostaje.service.TipoCompostajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Tipos de Compostaje.
 */
@Controller
@RequestMapping("/tipo-compostaje")
@RequiredArgsConstructor
public class TipoCompostajeController {

    private final TipoCompostajeService tipoCompostajeService;
}
