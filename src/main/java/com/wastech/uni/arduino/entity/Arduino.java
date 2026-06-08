package com.wastech.uni.arduino.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad Arduino.
 * Relación JPA:
 * - Es referenciada por Deshidratador (@ManyToOne) y Sensores (@ManyToOne).
 * - Un Arduino puede gestionar múltiples deshidratadores y sensores (1:N).
 */
@Entity
@Table(name = "arduino")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Arduino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_arduino", nullable = false)
    private Long idArduino;

    @NotBlank(message = "El nombre del Arduino no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede exceder los 50 caracteres")
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @NotBlank(message = "El modelo del Arduino no puede estar vacío")
    @Size(max = 50, message = "El modelo no puede exceder los 50 caracteres")
    @Column(name = "modelo", length = 50, nullable = false)
    private String modelo;
}
