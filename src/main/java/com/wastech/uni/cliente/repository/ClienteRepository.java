package com.wastech.uni.cliente.repository;

import com.wastech.uni.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository de acceso a datos para la entidad Cliente.
 * PK es de tipo String (cédula), no auto-generada.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    List<Cliente> findByNombre1ContainingIgnoreCase(String nombre);

    boolean existsByCedula(String cedula);
}
