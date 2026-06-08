package com.wastech.uni.cliente.service.impl;

import com.wastech.uni.cliente.entity.Cliente;
import com.wastech.uni.cliente.repository.ClienteRepository;
import com.wastech.uni.cliente.service.ClienteService;
import com.wastech.uni.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(String cedula) {
        return clienteRepository.findById(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findByNombre(String nombre) {
        return clienteRepository.findByNombre1ContainingIgnoreCase(nombre);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(String cedula) {
        if (!clienteRepository.existsById(cedula)) {
            throw new ResourceNotFoundException("Cliente", "cedula", cedula);
        }
        clienteRepository.deleteById(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByCedula(String cedula) {
        return clienteRepository.existsByCedula(cedula);
    }
}
