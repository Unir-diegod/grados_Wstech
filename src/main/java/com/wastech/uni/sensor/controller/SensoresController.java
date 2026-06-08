package com.wastech.uni.sensor.controller;

import com.wastech.uni.sensor.service.SensoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de sensores IoT.
 *
 * TODO (sprint IoT):
 *  - GET  /sensores        → listar sensores
 *  - GET  /sensores/{id}   → ver lecturas de un sensor
 */
@Controller
@RequestMapping("/sensores")
@RequiredArgsConstructor
public class SensoresController {

    private final SensoresService sensoresService;

    // TODO: implementar endpoints en el sprint de IoT
}
