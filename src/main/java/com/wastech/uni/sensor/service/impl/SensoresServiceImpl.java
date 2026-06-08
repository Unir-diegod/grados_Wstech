package com.wastech.uni.sensor.service.impl;

import com.wastech.uni.exception.ResourceNotFoundException;
import com.wastech.uni.sensor.entity.Sensores;
import com.wastech.uni.sensor.repository.SensoresRepository;
import com.wastech.uni.sensor.service.SensoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SensoresServiceImpl implements SensoresService {

    private final SensoresRepository sensoresRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Sensores> findAll() {
        return sensoresRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sensores> findById(Long id) {
        return sensoresRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sensores> findByArduino(Long idArduino) {
        return sensoresRepository.findByArduinoIdArduino(idArduino);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sensores> findByTipoSensor(Long idTipoSensor) {
        return sensoresRepository.findByTipoSensorIdTipoSensor(idTipoSensor);
    }

    @Override
    public Sensores save(Sensores sensor) {
        return sensoresRepository.save(sensor);
    }

    @Override
    public void deleteById(Long id) {
        if (!sensoresRepository.existsById(id)) {
            throw new ResourceNotFoundException("Sensor", "id", id);
        }
        sensoresRepository.deleteById(id);
    }
}
