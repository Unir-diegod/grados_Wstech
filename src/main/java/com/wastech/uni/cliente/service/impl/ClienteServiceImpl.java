package com.wastech.uni.cliente.service.impl;

import com.wastech.uni.cliente.dto.ClienteDTO;
import com.wastech.uni.cliente.entity.Cliente;
import com.wastech.uni.cliente.repository.ClienteRepository;
import com.wastech.uni.cliente.service.ClienteService;
import com.wastech.uni.exception.BusinessException;
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
    public List<Cliente> findByCedulaOrNombreOrApellido(String search) {
        if (search == null || search.trim().isEmpty()) return findAll();
        return clienteRepository.findByCedulaContainingIgnoreCaseOrNombre1ContainingIgnoreCaseOrApellido1ContainingIgnoreCase(search, search, search);
    }

    @Override
    public Cliente save(ClienteDTO dto) {
        if (clienteRepository.existsById(dto.getCedula())) {
            throw new BusinessException("Ya existe un cliente con la cédula ingresada");
        }
        Cliente cliente = new Cliente();
        mapDtoToEntity(dto, cliente);
        cliente.setCedula(dto.getCedula());
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(String cedula, ClienteDTO dto) {
        Cliente cliente = clienteRepository.findById(cedula)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "cedula", cedula));
        
        mapDtoToEntity(dto, cliente);
        // La cédula no se actualiza (PK)
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(String cedula) {
        if (!clienteRepository.existsById(cedula)) {
            throw new ResourceNotFoundException("Cliente", "cedula", cedula);
        }
        try {
            clienteRepository.deleteById(cedula);
        } catch (Exception e) {
            throw new BusinessException("No se puede eliminar el cliente porque está siendo referenciado en otros registros.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByCedula(String cedula) {
        return clienteRepository.existsByCedula(cedula);
    }

    private void mapDtoToEntity(ClienteDTO dto, Cliente entity) {
        entity.setNombre1(dto.getNombre1());
        entity.setNombre2(dto.getNombre2());
        entity.setApellido1(dto.getApellido1());
        entity.setApellido2(dto.getApellido2());
        entity.setTelefono(dto.getTelefono());
        entity.setDireccion(dto.getDireccion());
        entity.setCorreo(dto.getCorreo());
    }
}
