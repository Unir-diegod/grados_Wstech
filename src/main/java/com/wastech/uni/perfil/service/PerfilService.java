package com.wastech.uni.perfil.service;

import com.wastech.uni.perfil.entity.Perfil;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de servicio para la gestión de Perfiles.
 */
public interface PerfilService {

    List<Perfil> findAll();

    Optional<Perfil> findById(Long id);

    Optional<Perfil> findByNombre(String nombre);

    Perfil save(Perfil perfil);

    void deleteById(Long id);

    boolean existsByNombre(String nombre);
}
