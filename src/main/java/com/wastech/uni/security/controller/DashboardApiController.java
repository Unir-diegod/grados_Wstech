package com.wastech.uni.security.controller;

import com.wastech.uni.cliente.repository.ClienteRepository;
import com.wastech.uni.deshidratador.repository.DeshidratadorRepository;
import com.wastech.uni.registro.entity.Registro;
import com.wastech.uni.registro.repository.RegistroRepository;
import com.wastech.uni.sensor.entity.Alerta;
import com.wastech.uni.sensor.repository.AlertaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardApiController {

    private final ClienteRepository clienteRepository;
    private final DeshidratadorRepository deshidratadorRepository;
    private final RegistroRepository registroRepository;
    private final AlertaRepository alertaRepository;

    @GetMapping("/stats")
    public ResponseEntity<?> getStats() {
        long totalClientes = clienteRepository.count();
        long totalDeshidratadores = deshidratadorRepository.count();
        long totalAlertas = alertaRepository.count();

        List<Registro> todos = registroRepository.findAll();
        double totalCompostaje = todos.stream()
                .filter(r -> "FINALIZADO".equalsIgnoreCase(r.getEstado()))
                .mapToDouble(r -> r.getCantidad() != null ? r.getCantidad() : 0.0)
                .sum();

        List<Alerta> alertasRecientes = alertaRepository.findTop10ByOrderByFechaDesc();
        List<Map<String, Object>> alertasMap = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM HH:mm:ss");

        for (Alerta a : alertasRecientes) {
            Map<String, Object> map = new HashMap<>();
            map.put("mensaje", a.getMensaje());
            map.put("fecha", a.getFecha().format(formatter));
            alertasMap.add(map);
        }

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalClientes", totalClientes);
        stats.put("totalDeshidratadores", totalDeshidratadores);
        stats.put("totalAlertas", totalAlertas);
        stats.put("totalCompostaje", String.format("%.1f", totalCompostaje));
        stats.put("alertasRecientes", alertasMap);

        return ResponseEntity.ok(stats);
    }
}
