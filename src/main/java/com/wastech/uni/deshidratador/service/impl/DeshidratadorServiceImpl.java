package com.wastech.uni.deshidratador.service.impl;

import com.wastech.uni.deshidratador.entity.Deshidratador;
import com.wastech.uni.deshidratador.repository.DeshidratadorRepository;
import com.wastech.uni.deshidratador.service.DeshidratadorService;
import com.wastech.uni.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeshidratadorServiceImpl implements DeshidratadorService {

    private final DeshidratadorRepository deshidratadorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Deshidratador> findAll() {
        return deshidratadorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Deshidratador> findById(Long id) {
        return deshidratadorRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Deshidratador> findByArduino(Long idArduino) {
        return deshidratadorRepository.findByArduinoIdArduino(idArduino);
    }

    @Override
    public Deshidratador save(Deshidratador deshidratador) {
        return deshidratadorRepository.save(deshidratador);
    }

    @Override
    public void deleteById(Long id) {
        if (!deshidratadorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Deshidratador", "id", id);
        }
        deshidratadorRepository.deleteById(id);
    }
}
