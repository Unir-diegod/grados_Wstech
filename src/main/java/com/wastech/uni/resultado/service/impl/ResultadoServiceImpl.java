package com.wastech.uni.resultado.service.impl;

import com.wastech.uni.exception.ResourceNotFoundException;
import com.wastech.uni.resultado.entity.Resultado;
import com.wastech.uni.resultado.repository.ResultadoRepository;
import com.wastech.uni.resultado.service.ResultadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ResultadoServiceImpl implements ResultadoService {

    private final ResultadoRepository resultadoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Resultado> findAll() {
        return resultadoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Resultado> findById(Long id) {
        return resultadoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Resultado> findBySensor(Long idSensor) {
        return resultadoRepository.findBySensorIdSensor(idSensor);
    }

    @Override
    public Resultado save(Resultado resultado) {
        return resultadoRepository.save(resultado);
    }

    @Override
    public void deleteById(Long id) {
        if (!resultadoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Resultado", "id", id);
        }
        resultadoRepository.deleteById(id);
    }
}
