package com.wastech.uni.cliente.service;

import com.wastech.uni.cliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de servicio para la gestión de Clientes.
 */
public interface ClienteService {

    List<Cliente> findAll();

    Optional<Cliente> findById(String cedula);

    List<Cliente> findByNombre(String nombre);

    Cliente save(Cliente cliente);

    void deleteById(String cedula);

    boolean existsByCedula(String cedula);
}
