package com.wastech.uni.perfil.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad Perfil.
 * Relación JPA: Un perfil puede estar asociado a múltiples usuarios (Relación 1:N). 
 * Por ahora, mantenemos la relación unidireccional desde Usuario para simplificar, 
 * o la mapearemos bidireccionalmente cuando se cree la entidad Usuario.
 */
@Entity
@Table(name = "Perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDperfil", nullable = false)
    private Long idperfil;

    @NotBlank(message = "El nombre del perfil no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede exceder los 50 caracteres")
    @Column(name = "Nombre", length = 50, nullable = false)
    private String nombre;
}
