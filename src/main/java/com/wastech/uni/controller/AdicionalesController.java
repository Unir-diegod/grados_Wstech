package com.wastech.uni.controller;

import com.wastech.uni.compostaje.repository.TipoCompostajeRepository;
import com.wastech.uni.resultado.repository.ResultadoRepository;
import com.wastech.uni.sensor.repository.SensoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdicionalesController {

    private final ResultadoRepository resultadoRepository;
    private final TipoCompostajeRepository tipoCompostajeRepository;
    private final SensoresRepository sensoresRepository;

    @GetMapping("/")
    public String root() {
        return "redirect:/dashboard";
    }

    @GetMapping("/resultados")
    public String resultados(Model model) {
        model.addAttribute("resultados", resultadoRepository.findAll());
        return "resultados/lista";
    }

    @GetMapping("/compostaje")
    public String compostaje(Model model) {
        model.addAttribute("tiposCompostaje", tipoCompostajeRepository.findAll());
        return "tipo-compostaje/lista";
    }

    @GetMapping("/sensores")
    public String sensores(Model model) {
        model.addAttribute("lecturas", sensoresRepository.findAll());
        return "sensores/lista";
    }

    @GetMapping("/reportes")
    public String reportes(Model model) {
        model.addAttribute("resultados", resultadoRepository.findAll());
        return "resultados/lista";
    }

    @GetMapping("/configuracion")
    public String configuracion() {
        return "ajustes/lista";
    }
}
