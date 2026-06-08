package com.wastech.uni.cliente.entity;

import com.wastech.uni.registro.entity.Registro;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad Cliente.
 * Relación JPA:
 * - @ManyToOne con Registro (ID_registro): Un cliente puede tener asociado
 *   un registro de proceso. Relación N:1 desde Cliente hacia Registro.
 * - @OneToMany inverso: Un registro puede tener muchos clientes (si aplica).
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

    @NotBlank(message = "El primer nombre no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede exceder los 50 caracteres")
    @Column(name = "Nombre_1", length = 50, nullable = false)
    private String nombre1;

    @Size(max = 50, message = "El segundo nombre no puede exceder los 50 caracteres")
    @Column(name = "Nombre_2", length = 50)
    private String nombre2;

    @NotBlank(message = "El primer apellido no puede estar vacío")
    @Size(max = 50, message = "El apellido no puede exceder los 50 caracteres")
    @Column(name = "Apellido_1", length = 50, nullable = false)
    private String apellido1;

    @Size(max = 50, message = "El segundo apellido no puede exceder los 50 caracteres")
    @Column(name = "Apellido_2", length = 50)
    private String apellido2;

    @Size(max = 20, message = "El teléfono no puede exceder los 20 caracteres")
    @Column(name = "Telefono", length = 20)
    private String telefono;

    @Size(max = 200, message = "La dirección no puede exceder los 200 caracteres")
    @Column(name = "Direccion", length = 200)
    private String direccion;

    @Email(message = "El correo debe tener un formato válido")
    @Size(max = 100, message = "El correo no puede exceder los 100 caracteres")
    @Column(name = "Correo", length = 100)
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_registro")
    private Registro registro;
}
