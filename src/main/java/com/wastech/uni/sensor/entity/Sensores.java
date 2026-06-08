package com.wastech.uni.sensor.entity;

import com.wastech.uni.arduino.entity.Arduino;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entidad Sensores.
 * Relación JPA:
 * - @ManyToOne con TipoSensor (ID_tiposensor): Muchos sensores pertenecen a un tipo.
 * - @ManyToOne con Arduino (ID_arduino): Muchos sensores son gestionados por un Arduino.
 */
@Entity
@Table(name = "Sensores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sensores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_sensor", nullable = false)
    private Long idSensor;

    @Column(name = "Valor_lectura")
    private Double valorLectura;

    @Column(name = "Frcha_lectura") // Nombre de columna respeta el diagrama original
    private LocalDateTime frchaLectura;

    @NotNull(message = "El tipo de sensor es obligatorio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_tiposensor", nullable = false)
    private TipoSensor tipoSensor;

    @NotNull(message = "El Arduino es obligatorio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_arduino", nullable = false)
    private Arduino arduino;
}
