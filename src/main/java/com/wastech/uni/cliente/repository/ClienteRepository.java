package com.wastech.uni.cliente.repository;

import com.wastech.uni.cliente.entity.Cliente;
import com.wastech.uni.registro.entity.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    List<Cliente> findByCedulaContainingIgnoreCaseOrNombre1ContainingIgnoreCaseOrApellido1ContainingIgnoreCase(
            String cedula, String nombre1, String apellido1);

    List<Cliente> findByNombre1ContainingIgnoreCase(String nombre);

    boolean existsByCedula(String cedula);

    List<Cliente> findByRegistroIdRegistro(Long idRegistro);
}

