package com.wastech.uni.registro.controller;

import com.wastech.uni.cliente.entity.Cliente;
import com.wastech.uni.cliente.repository.ClienteRepository;
import com.wastech.uni.compostaje.entity.TipoCompostaje;
import com.wastech.uni.compostaje.repository.TipoCompostajeRepository;
import com.wastech.uni.deshidratador.entity.Deshidratador;
import com.wastech.uni.deshidratador.repository.DeshidratadorRepository;
import com.wastech.uni.materiaPrima.entity.TipoMateriaPrima;
import com.wastech.uni.materiaPrima.repository.TipoMateriaPrimaRepository;
import com.wastech.uni.registro.entity.Registro;
import com.wastech.uni.registro.repository.RegistroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/registros")
@RequiredArgsConstructor
public class RegistroController {

    private final RegistroRepository registroRepository;
    private final ClienteRepository clienteRepository;
    private final DeshidratadorRepository deshidratadorRepository;
    private final TipoCompostajeRepository tipoCompostajeRepository;
    private final TipoMateriaPrimaRepository tipoMateriaPrimaRepository;

    @GetMapping
    public String index(
            @RequestParam(required = false) String fechaInicio,
            @RequestParam(required = false) String fechaFin,
            Model model) {

        List<Registro> registros;
        if (fechaInicio != null && !fechaInicio.isBlank() && fechaFin != null && !fechaFin.isBlank()) {
            try {
                LocalDate start = LocalDate.parse(fechaInicio);
                LocalDate end = LocalDate.parse(fechaFin);
                LocalDateTime startDateTime = start.atStartOfDay();
                LocalDateTime endDateTime = end.atTime(LocalTime.MAX);
                registros = registroRepository.findByFechaInicioBetween(startDateTime, endDateTime);
                model.addAttribute("fechaInicio", fechaInicio);
                model.addAttribute("fechaFin", fechaFin);
            } catch (Exception e) {
                registros = registroRepository.findAll();
                model.addAttribute("error", "Formato de fechas incorrecto.");
            }
        } else {
            registros = registroRepository.findAll();
        }

        model.addAttribute("registros", registros);
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("deshidratadores", deshidratadorRepository.findAll());
        model.addAttribute("tiposCompostaje", tipoCompostajeRepository.findAll());
        model.addAttribute("tiposMateriaPrima", tipoMateriaPrimaRepository.findAll());

        return "registros/lista";
    }

    @PostMapping("/iniciar")
    public String iniciarCiclo(
            @RequestParam Long idDeshidratador,
            @RequestParam String cedula,
            @RequestParam Long idCompostaje,
            @RequestParam Long idMatep,
            @RequestParam Double cantidad,
            RedirectAttributes redirectAttributes) {

        try {
            Deshidratador des = deshidratadorRepository.findById(idDeshidratador)
                    .orElseThrow(() -> new IllegalArgumentException("Deshidratador no encontrado"));
            Cliente cli = clienteRepository.findById(cedula)
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
            TipoCompostaje comp = tipoCompostajeRepository.findById(idCompostaje)
                    .orElseThrow(() -> new IllegalArgumentException("Tipo de Compostaje no encontrado"));
            TipoMateriaPrima mat = tipoMateriaPrimaRepository.findById(idMatep)
                    .orElseThrow(() -> new IllegalArgumentException("Tipo de Materia Prima no encontrado"));

            // Validar si el deshidratador ya tiene un ciclo activo
            List<Registro> desRegistros = registroRepository.findByDeshidratadorIdDeshidratador(idDeshidratador);
            for (Registro r : desRegistros) {
                if ("ACTIVO".equalsIgnoreCase(r.getEstado())) {
                    throw new IllegalStateException("El deshidratador ya tiene un ciclo activo.");
                }
            }

            // Validar si el cliente ya tiene un ciclo activo
            if (cli.getRegistro() != null && "ACTIVO".equalsIgnoreCase(cli.getRegistro().getEstado())) {
                throw new IllegalStateException("El cliente ya está asociado a un ciclo activo.");
            }

            Registro reg = new Registro();
            reg.setDeshidratador(des);
            reg.setTipoCompostaje(comp);
            reg.setTipoMateriaPrima(mat);
            reg.setCantidad(cantidad);
            reg.setFechaInicio(LocalDateTime.now());
            reg.setEstado("ACTIVO");
            reg.setTemperatura(0.0);
            reg.setHumedad(0.0);

            Registro regGuardado = registroRepository.save(reg);

            // Asociar al cliente
            cli.setRegistro(regGuardado);
            clienteRepository.save(cli);

            redirectAttributes.addFlashAttribute("exito", "Ciclo de compostaje iniciado correctamente para " + cli.getNombre1() + ".");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/registros";
    }

    @PostMapping("/cerrar/{id}")
    public String cerrarCiclo(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes) {

        try {
            Registro reg = registroRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Ciclo no encontrado"));

            if (!"ACTIVO".equalsIgnoreCase(reg.getEstado())) {
                throw new IllegalStateException("El ciclo no está activo.");
            }

            reg.setEstado("FINALIZADO");
            reg.setFechaFin(LocalDateTime.now());
            registroRepository.save(reg);

            // Desvincular clientes
            List<Cliente> clientes = clienteRepository.findByRegistroIdRegistro(id);
            for (Cliente cli : clientes) {
                cli.setRegistro(null);
                clienteRepository.save(cli);
            }

            redirectAttributes.addFlashAttribute("exito", "Ciclo finalizado y guardado en el historial con éxito.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/registros";
    }

    @GetMapping("/grafico/{id}")
    public String verGrafico(@PathVariable Long id, Model model) {
        Registro reg = registroRepository.findById(id).orElse(null);
        if (reg == null) {
            return "redirect:/registros";
        }
        model.addAttribute("registro", reg);
        return "registros/grafico";
    }
}
