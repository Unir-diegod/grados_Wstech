package com.wastech.uni.registro.controller;

import com.wastech.uni.registro.service.RegistroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de registros de proceso.
 *
 * TODO (sprint gestión de procesos):
 *  - GET  /registros       → listar registros
 *  - GET  /registros/{id}  → ver detalle de registro
 *  - POST /registros       → crear nuevo registro de proceso
 */
@Controller
@RequestMapping("/registros")
@RequiredArgsConstructor
public class RegistroController {

    private final RegistroService registroService;

    // TODO: implementar endpoints en el sprint de gestión de procesos
}
