package com.wastech.uni.perfil.service.impl;

import com.wastech.uni.exception.ResourceNotFoundException;
import com.wastech.uni.perfil.entity.Perfil;
import com.wastech.uni.perfil.repository.PerfilRepository;
import com.wastech.uni.perfil.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PerfilServiceImpl implements PerfilService {

    private final PerfilRepository perfilRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Perfil> findById(Long id) {
        return perfilRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Perfil> findByNombre(String nombre) {
        return perfilRepository.findFirstByNombreOrderByIdperfilAsc(nombre);
    }

    @Override
    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public void deleteById(Long id) {
        if (!perfilRepository.existsById(id)) {
            throw new ResourceNotFoundException("Perfil", "id", id);
        }
        perfilRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByNombre(String nombre) {
        return perfilRepository.existsByNombre(nombre);
    }
}
