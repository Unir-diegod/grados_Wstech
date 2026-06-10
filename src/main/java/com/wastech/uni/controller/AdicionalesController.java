package com.wastech.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdicionalesController {

    @GetMapping("/")
    public String root() {
        return "redirect:/dashboard";
    }

    @GetMapping("/resultados")
    public String resultados() {
        return "resultados/lista";
    }

    @GetMapping("/compostaje")
    public String compostaje() {
        return "tipo-compostaje/lista";
    }

    @GetMapping("/sensores")
    public String sensores() {
        return "sensores/lista";
    }

    @GetMapping("/reportes")
    public String reportes() {
        return "resultados/lista";
    }

    @GetMapping("/configuracion")
    public String configuracion() {
        return "ajustes/lista";
    }
}
