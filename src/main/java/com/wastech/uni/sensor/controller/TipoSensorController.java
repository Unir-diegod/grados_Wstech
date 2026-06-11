package com.wastech.uni.sensor.controller;

import com.wastech.uni.sensor.repository.TipoSensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Tipos de Sensor.
 */
@Controller
@RequestMapping("/tipo-sensor")
@RequiredArgsConstructor
public class TipoSensorController {

    private final TipoSensorRepository tipoSensorRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tiposSensores", tipoSensorRepository.findAll());
        return "tipo-sensor/lista";
    }
}
