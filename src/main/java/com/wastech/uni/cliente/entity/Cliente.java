package com.wastech.uni.cliente.entity;

import com.wastech.uni.registro.entity.Registro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad Cliente.
 * Relación JPA:
 * - Contiene la FK ID_registro hacia la tabla resgistro según el diagrama.
 */
@Entity
@Table(name = "Cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @Column(name = "Cedula", nullable = false, length = 20)
    private String cedula;

    @Column(name = "Nombre_1", length = 50)
    private String nombre1;

    @Column(name = "Nombre_2", length = 50)
    private String nombre2;

    @Column(name = "Apellido_1", length = 50)
    private String apellido1;

    @Column(name = "Apellido_2", length = 50)
    private String apellido2;

    @Column(name = "Telefono", length = 20)
    private String telefono;

    @Column(name = "Direccion", length = 200)
    private String direccion;

    @Column(name = "Correo", length = 100)
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_registro")
    private Registro registro;
}
