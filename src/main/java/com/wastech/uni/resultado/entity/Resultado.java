package com.wastech.uni.resultado.entity;

import com.wastech.uni.sensor.entity.Sensores;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entidad Resultado.
 * Relación JPA:
 * - @ManyToOne con Sensores (ID_sensor)
 */
@Entity
@Table(name = "Resultado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resultado {

    @Id
    @Column(name = "Cod_resultado", nullable = false)
    private Long codResultado;

    @Column(name = "Fecha_de_inicio") // Espacios a guion bajo
    private LocalDateTime fechaDeInicio;

    @Column(name = "Fecha_de_fin") // Espacios a guion bajo
    private LocalDateTime fechaDeFin;

    @Column(name = "Valor")
    private Double valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_sensor")
    private Sensores sensor;
}
