package com.wastech.uni.materiaPrima.service.impl;

import com.wastech.uni.exception.ResourceNotFoundException;
import com.wastech.uni.materiaPrima.entity.TipoMateriaPrima;
import com.wastech.uni.materiaPrima.repository.TipoMateriaPrimaRepository;
import com.wastech.uni.materiaPrima.service.TipoMateriaPrimaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TipoMateriaPrimaServiceImpl implements TipoMateriaPrimaService {

    private final TipoMateriaPrimaRepository tipoMateriaPrimaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TipoMateriaPrima> findAll() {
        return tipoMateriaPrimaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoMateriaPrima> findById(Long id) {
        return tipoMateriaPrimaRepository.findById(id);
    }

    @Override
    public TipoMateriaPrima save(TipoMateriaPrima tipoMateriaPrima) {
        return tipoMateriaPrimaRepository.save(tipoMateriaPrima);
    }

    @Override
    public void deleteById(Long id) {
        if (!tipoMateriaPrimaRepository.existsById(id)) {
            throw new ResourceNotFoundException("TipoMateriaPrima", "id", id);
        }
        tipoMateriaPrimaRepository.deleteById(id);
    }
}
