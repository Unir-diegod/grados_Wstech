package com.wastech.uni.perfil.controller;

import com.wastech.uni.perfil.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Perfiles.
 */
@Controller
@RequestMapping("/perfiles")
@RequiredArgsConstructor
public class PerfilController {

    private final PerfilService perfilService;
}
