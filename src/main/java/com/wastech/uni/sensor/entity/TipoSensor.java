package com.wastech.uni.sensor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad TipoSensor.
 * Relación JPA:
 * - Es referenciada por Sensores a través de ID_tiposensor.
 */
@Entity
@Table(name = "tipo_sensor") // Espacio no válido en base de datos típica, usamos guion bajo
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoSensor {

    @Id
    @Column(name = "ID_tiposensor", nullable = false)
    private Long idTipoSensor;

    @Column(name = "nombre_sesor", length = 50) // Respetando el typo de la imagen "nombre_sesor"
    private String nombreSesor;
}
