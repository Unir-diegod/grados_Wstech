package com.wastech.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdicionalesController {

    @GetMapping("/compostaje")
    public String compostaje() {
        return "en-construccion";
    }

    @GetMapping("/sensores")
    public String sensores() {
        return "en-construccion";
    }

    @GetMapping("/reportes")
    public String reportes() {
        return "en-construccion";
    }

    @GetMapping("/configuracion")
    public String configuracion() {
        return "en-construccion";
    }
}
