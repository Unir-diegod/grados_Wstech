package com.wastech.uni.arduino.controller;

import com.wastech.uni.arduino.service.ArduinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de dispositivos Arduino.
 *
 * TODO (sprint gestión de dispositivos):
 *  - GET  /arduinos       → listar todos los dispositivos
 *  - GET  /arduinos/{id}  → ver detalle
 *  - POST /arduinos       → registrar nuevo dispositivo
 */
@Controller
@RequestMapping("/arduinos")
@RequiredArgsConstructor
public class ArduinoController {

    private final ArduinoService arduinoService;

    // TODO: implementar endpoints en el sprint de gestión de dispositivos
}
