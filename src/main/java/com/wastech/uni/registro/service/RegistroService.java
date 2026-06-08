package com.wastech.uni.registro.service;

import com.wastech.uni.registro.entity.Registro;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de servicio para la gestión de registros de proceso.
 */
public interface RegistroService {

    List<Registro> findAll();

    Optional<Registro> findById(Long id);

    List<Registro> findByEstado(String estado);

    List<Registro> findByDeshidratador(Long idDeshidratador);

    Registro save(Registro registro);

    void deleteById(Long id);
}
