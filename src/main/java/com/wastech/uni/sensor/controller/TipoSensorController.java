package com.wastech.uni.sensor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Tipos de Sensor.
 */
@Controller
@RequestMapping("/tipo-sensor")
public class TipoSensorController {

    @org.springframework.web.bind.annotation.GetMapping
    public String index() {
        return "tipo-sensor/lista";
    }
}
