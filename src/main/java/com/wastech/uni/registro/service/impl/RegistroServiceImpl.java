package com.wastech.uni.registro.service.impl;

import com.wastech.uni.exception.ResourceNotFoundException;
import com.wastech.uni.registro.entity.Registro;
import com.wastech.uni.registro.repository.RegistroRepository;
import com.wastech.uni.registro.service.RegistroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistroServiceImpl implements RegistroService {

    private final RegistroRepository registroRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Registro> findAll() {
        return registroRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Registro> findById(Long id) {
        return registroRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Registro> findByEstado(String estado) {
        return registroRepository.findByEstado(estado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Registro> findByDeshidratador(Long idDeshidratador) {
        return registroRepository.findByDeshidratadorIdDeshidratador(idDeshidratador);
    }

    @Override
    public Registro save(Registro registro) {
        return registroRepository.save(registro);
    }

    @Override
    public void deleteById(Long id) {
        if (!registroRepository.existsById(id)) {
            throw new ResourceNotFoundException("Registro", "id", id);
        }
        registroRepository.deleteById(id);
    }
}
