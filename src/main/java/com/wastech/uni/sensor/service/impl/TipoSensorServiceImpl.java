package com.wastech.uni.sensor.service.impl;

import com.wastech.uni.exception.ResourceNotFoundException;
import com.wastech.uni.sensor.entity.TipoSensor;
import com.wastech.uni.sensor.repository.TipoSensorRepository;
import com.wastech.uni.sensor.service.TipoSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TipoSensorServiceImpl implements TipoSensorService {

    private final TipoSensorRepository tipoSensorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TipoSensor> findAll() {
        return tipoSensorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoSensor> findById(Long id) {
        return tipoSensorRepository.findById(id);
    }

    @Override
    public TipoSensor save(TipoSensor tipoSensor) {
        return tipoSensorRepository.save(tipoSensor);
    }

    @Override
    public void deleteById(Long id) {
        if (!tipoSensorRepository.existsById(id)) {
            throw new ResourceNotFoundException("TipoSensor", "id", id);
        }
        tipoSensorRepository.deleteById(id);
    }
}
