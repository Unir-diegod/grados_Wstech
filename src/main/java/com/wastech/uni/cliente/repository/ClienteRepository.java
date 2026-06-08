package com.wastech.uni.cliente.repository;

import com.wastech.uni.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository de acceso a datos para la entidad Cliente.
 *  - findByClienteCedula(String cedula) para búsqueda por cliente
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    // Para la vista de búsqueda
    List<Cliente> findByCedulaContainingIgnoreCaseOrNombre1ContainingIgnoreCaseOrApellido1ContainingIgnoreCase(
            String cedula, String nombre1, String apellido1);

    List<Cliente> findByNombre1ContainingIgnoreCase(String nombre);

    boolean existsByCedula(String cedula);
}
