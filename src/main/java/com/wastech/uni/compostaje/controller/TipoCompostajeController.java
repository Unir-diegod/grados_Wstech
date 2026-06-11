package com.wastech.uni.compostaje.controller;

import com.wastech.uni.compostaje.repository.TipoCompostajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Tipos de Compostaje.
 */
@Controller
@RequestMapping("/tipo-compostaje")
@RequiredArgsConstructor
public class TipoCompostajeController {

    private final TipoCompostajeRepository tipoCompostajeRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tiposCompostaje", tipoCompostajeRepository.findAll());
        return "tipo-compostaje/lista";
    }
}
