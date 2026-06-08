package com.wastech.uni.resultado.controller;

import com.wastech.uni.resultado.service.ResultadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Resultados.
 */
@Controller
@RequestMapping("/resultados")
@RequiredArgsConstructor
public class ResultadoController {

    private final ResultadoService resultadoService;
}
