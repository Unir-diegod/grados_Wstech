package com.wastech.uni.deshidratador.entity;

import com.wastech.uni.arduino.entity.Arduino;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad Deshidratador.
 * Relación JPA:
 * - @ManyToOne con Arduino (ID_arduino): Muchos deshidratadores son controlados por un Arduino.
 * - Es referenciada por Registro a través de ID_deshidratador (Relación 1:N desde Deshidratador).
 */
@Entity
@Table(name = "deshidratador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Deshidratador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_deshidratador", nullable = false)
    private Long idDeshidratador;

    @Column(name = "calentador")
    private Boolean calentador;

    @NotNull(message = "El Arduino es obligatorio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_arduino", nullable = false)
    private Arduino arduino;
}
