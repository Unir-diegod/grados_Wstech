package com.wastech.uni.sensor.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad TipoSensor.
 * Relación JPA:
 * - Es referenciada por Sensores a través de ID_tiposensor.
 * - Un TipoSensor puede tener múltiples Sensores asociados (1:N).
 */
@Entity
@Table(name = "tipo_sensor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_tiposensor", nullable = false)
    private Long idTipoSensor;

    @NotBlank(message = "El nombre del tipo de sensor no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede exceder los 50 caracteres")
    @Column(name = "nombre_sesor", length = 50, nullable = false) // Nombre de columna respeta el diagrama original
    private String nombreSesor;
}
