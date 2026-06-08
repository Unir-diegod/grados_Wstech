package com.wastech.uni.arduino.service.impl;

import com.wastech.uni.arduino.entity.Arduino;
import com.wastech.uni.arduino.repository.ArduinoRepository;
import com.wastech.uni.arduino.service.ArduinoService;
import com.wastech.uni.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ArduinoServiceImpl implements ArduinoService {

    private final ArduinoRepository arduinoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Arduino> findAll() {
        return arduinoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Arduino> findById(Long id) {
        return arduinoRepository.findById(id);
    }

    @Override
    public Arduino save(Arduino arduino) {
        return arduinoRepository.save(arduino);
    }

    @Override
    public void deleteById(Long id) {
        if (!arduinoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Arduino", "id", id);
        }
        arduinoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByNombre(String nombre) {
        return arduinoRepository.existsByNombre(nombre);
    }
}
