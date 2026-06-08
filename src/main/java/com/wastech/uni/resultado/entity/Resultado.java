package com.wastech.uni.resultado.entity;

import com.wastech.uni.sensor.entity.Sensores;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entidad Resultado.
 * Relación JPA:
 * - @ManyToOne con Sensores (ID_sensor): Un resultado pertenece a una lectura de sensor.
 * - Muchos resultados pueden provenir del mismo sensor (N:1).
 */
@Entity
@Table(name = "Resultado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cod_resultado", nullable = false)
    private Long codResultado;

    @Column(name = "Fecha_de_inicio")
    private LocalDateTime fechaDeInicio;

    @Column(name = "Fecha_de_fin")
    private LocalDateTime fechaDeFin;

    @Column(name = "Valor")
    private Double valor;

    @NotNull(message = "El sensor es obligatorio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_sensor", nullable = false)
    private Sensores sensor;
}
