package com.wastech.uni.sensor.controller;

import com.wastech.uni.sensor.service.TipoSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Tipos de Sensor.
 */
@Controller
@RequestMapping("/tipo-sensor")
@RequiredArgsConstructor
public class TipoSensorController {

    private final TipoSensorService tipoSensorService;
}
