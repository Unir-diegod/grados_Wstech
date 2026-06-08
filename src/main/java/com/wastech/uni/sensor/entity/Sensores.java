package com.wastech.uni.sensor.entity;

import com.wastech.uni.arduino.entity.Arduino;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entidad Sensores.
 * Relación JPA:
 * - @ManyToOne con TipoSensor (ID_tiposensor)
 * - @ManyToOne con Arduino (ID_arduino)
 */
@Entity
@Table(name = "Sensores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sensores {

    @Id
    @Column(name = "ID_sensor", nullable = false)
    private Long idSensor;

    @Column(name = "Valor_lectura")
    private Double valorLectura;

    @Column(name = "Frcha_lectura") // Respetando el typo de la imagen "Frcha_lectura"
    private LocalDateTime frchaLectura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_tiposensor")
    private TipoSensor tipoSensor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_arduino")
    private Arduino arduino;
}
