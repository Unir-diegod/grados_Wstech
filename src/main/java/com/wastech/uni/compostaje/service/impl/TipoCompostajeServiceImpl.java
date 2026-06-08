package com.wastech.uni.compostaje.service.impl;

import com.wastech.uni.compostaje.entity.TipoCompostaje;
import com.wastech.uni.compostaje.repository.TipoCompostajeRepository;
import com.wastech.uni.compostaje.service.TipoCompostajeService;
import com.wastech.uni.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TipoCompostajeServiceImpl implements TipoCompostajeService {

    private final TipoCompostajeRepository tipoCompostajeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TipoCompostaje> findAll() {
        return tipoCompostajeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoCompostaje> findById(Long id) {
        return tipoCompostajeRepository.findById(id);
    }

    @Override
    public TipoCompostaje save(TipoCompostaje tipoCompostaje) {
        return tipoCompostajeRepository.save(tipoCompostaje);
    }

    @Override
    public void deleteById(Long id) {
        if (!tipoCompostajeRepository.existsById(id)) {
            throw new ResourceNotFoundException("TipoCompostaje", "id", id);
        }
        tipoCompostajeRepository.deleteById(id);
    }
}
