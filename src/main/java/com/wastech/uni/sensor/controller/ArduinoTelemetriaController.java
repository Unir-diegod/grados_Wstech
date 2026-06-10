package com.wastech.uni.sensor.controller;

import com.wastech.uni.arduino.entity.Arduino;
import com.wastech.uni.arduino.repository.ArduinoRepository;
import com.wastech.uni.deshidratador.entity.Deshidratador;
import com.wastech.uni.deshidratador.repository.DeshidratadorRepository;
import com.wastech.uni.registro.entity.Registro;
import com.wastech.uni.registro.repository.RegistroRepository;
import com.wastech.uni.sensor.entity.Alerta;
import com.wastech.uni.sensor.entity.Sensores;
import com.wastech.uni.sensor.entity.TipoSensor;
import com.wastech.uni.sensor.repository.AlertaRepository;
import com.wastech.uni.sensor.repository.SensoresRepository;
import com.wastech.uni.sensor.repository.TipoSensorRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sensores")
@RequiredArgsConstructor
public class ArduinoTelemetriaController {

    private final ArduinoRepository arduinoRepository;
    private final TipoSensorRepository tipoSensorRepository;
    private final SensoresRepository sensoresRepository;
    private final DeshidratadorRepository deshidratadorRepository;
    private final RegistroRepository registroRepository;
    private final AlertaRepository alertaRepository;

    @PostMapping("/lectura")
    @Transactional
    public ResponseEntity<?> recibirLectura(@RequestBody LecturaSensorRequest request) {
        Long idArduino = request.getIdArduino();
        Double temperatura = request.getTemperatura();
        Double humedad = request.getHumedad();

        if (idArduino == null || temperatura == null || humedad == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Faltan parámetros idArduino, temperatura o humedad."));
        }

        Arduino arduino = arduinoRepository.findById(idArduino).orElse(null);
        if (arduino == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "El Arduino con ID " + idArduino + " no existe."));
        }

        TipoSensor sensorTemp = tipoSensorRepository.findById(1L).orElse(null);
        TipoSensor sensorHum = tipoSensorRepository.findById(2L).orElse(null);

        if (sensorTemp == null || sensorHum == null) {
            return ResponseEntity.internalServerError().body(Map.of("error", "Los tipos de sensor (TEMPERATURA/HUMEDAD) no están inicializados."));
        }

        LocalDateTime ahora = LocalDateTime.now();

        // 1. Guardar la lectura de Temperatura en la BD
        Sensores lecturaTemp = new Sensores();
        lecturaTemp.setValorLectura(temperatura);
        lecturaTemp.setFrchaLectura(ahora);
        lecturaTemp.setTipoSensor(sensorTemp);
        lecturaTemp.setArduino(arduino);
        sensoresRepository.save(lecturaTemp);

        // 2. Guardar la lectura de Humedad en la BD
        Sensores lecturaHum = new Sensores();
        lecturaHum.setValorLectura(humedad);
        lecturaHum.setFrchaLectura(ahora);
        lecturaHum.setTipoSensor(sensorHum);
        lecturaHum.setArduino(arduino);
        sensoresRepository.save(lecturaHum);

        // 3. Buscar ciclos activos en los deshidratadores asociados a este Arduino
        List<Deshidratador> deshidratadores = deshidratadorRepository.findByArduinoIdArduino(idArduino);
        Map<String, Object> log = new HashMap<>();
        log.put("lecturaTemperatura", temperatura);
        log.put("lecturaHumedad", humedad);
        log.put("alertaGenerada", false);

        for (Deshidratador deshidratador : deshidratadores) {
            List<Registro> registros = registroRepository.findByDeshidratadorIdDeshidratador(deshidratador.getIdDeshidratador());
            for (Registro registro : registros) {
                if ("ACTIVO".equalsIgnoreCase(registro.getEstado())) {
                    // Actualizar el estado de temperatura y humedad instantáneo del ciclo
                    registro.setTemperatura(temperatura);
                    registro.setHumedad(humedad);
                    registroRepository.save(registro);

                    // Verificar límites del tipo de compostaje del ciclo
                    Double limiteTemp = registro.getTipoCompostaje().getTemperaturaLiminte();
                    if (limiteTemp != null && temperatura > limiteTemp) {
                        Alerta alerta = new Alerta();
                        alerta.setMensaje(String.format("¡Alerta! Temperatura excedida en deshidratador %d: %.1f°C (límite: %.1f°C)", 
                                deshidratador.getIdDeshidratador(), temperatura, limiteTemp));
                        alerta.setFecha(ahora);
                        alerta.setRegistro(registro);
                        alertaRepository.save(alerta);

                        log.put("alertaGenerada", true);
                        log.put("alertaMensaje", alerta.getMensaje());
                    }
                }
            }
        }

        return ResponseEntity.ok(Map.of("status", "Lecturas guardadas", "data", log));
    }

    @Data
    public static class LecturaSensorRequest {
        private Long idArduino;
        private Double temperatura;
        private Double humedad;
    }
}
