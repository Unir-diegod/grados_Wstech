package com.wastech.uni.arduino.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad Arduino.
 * Relación JPA:
 * - Es referenciada por deshidratador y Sensores.
 */
@Entity
@Table(name = "arduino")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Arduino {

    @Id
    @Column(name = "ID_arduino", nullable = false)
    private Long idArduino;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "modelo", length = 50)
    private String modelo;
}
