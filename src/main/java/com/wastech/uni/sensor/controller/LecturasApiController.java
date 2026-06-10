package com.wastech.uni.sensor.controller;

import com.wastech.uni.arduino.entity.Arduino;
import com.wastech.uni.registro.entity.Registro;
import com.wastech.uni.registro.repository.RegistroRepository;
import com.wastech.uni.sensor.entity.Sensores;
import com.wastech.uni.sensor.repository.SensoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/registros")
@RequiredArgsConstructor
public class LecturasApiController {

    private final RegistroRepository registroRepository;
    private final SensoresRepository sensoresRepository;

    @GetMapping("/{id}/lecturas")
    public ResponseEntity<?> obtenerLecturasDeCiclo(@PathVariable Long id) {
        Registro registro = registroRepository.findById(id).orElse(null);
        if (registro == null) {
            return ResponseEntity.notFound().build();
        }

        Arduino arduino = registro.getDeshidratador().getArduino();
        if (arduino == null) {
            return ResponseEntity.ok(Collections.emptyList());
        }

        LocalDateTime inicio = registro.getFechaInicio() != null ? registro.getFechaInicio() : LocalDateTime.now().minusHours(24);
        LocalDateTime fin = registro.getFechaFin() != null ? registro.getFechaFin() : LocalDateTime.now();

        List<Sensores> lecturas = sensoresRepository.findByArduinoIdArduino(arduino.getIdArduino());

        List<Sensores> lecturasCiclo = lecturas.stream()
                .filter(s -> s.getFrchaLectura() != null && !s.getFrchaLectura().isBefore(inicio) && !s.getFrchaLectura().isAfter(fin))
                .sorted(Comparator.comparing(Sensores::getFrchaLectura))
                .collect(Collectors.toList());

        List<Map<String, Object>> response = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM HH:mm:ss");

        for (Sensores lectura : lecturasCiclo) {
            Map<String, Object> map = new HashMap<>();
            map.put("fecha", lectura.getFrchaLectura().format(formatter));
            map.put("valor", lectura.getValorLectura());
            map.put("tipo", lectura.getTipoSensor().getNombreSesor()); // TEMPERATURA o HUMEDAD
            response.add(map);
        }

        return ResponseEntity.ok(response);
    }
}
