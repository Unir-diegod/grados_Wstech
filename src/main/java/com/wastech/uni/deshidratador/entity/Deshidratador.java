package com.wastech.uni.deshidratador.entity;

import com.wastech.uni.arduino.entity.Arduino;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad Deshidratador.
 * Relación JPA:
 * - @ManyToOne con Arduino (ID_arduino)
 * - Es referenciada por resgistro a través de ID_deshidratador.
 */
@Entity
@Table(name = "deshidratador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Deshidratador {

    @Id
    @Column(name = "ID_deshidratador", nullable = false)
    private Long idDeshidratador;

    @Column(name = "calentador")
    private Boolean calentador; // Asumiendo boolean o string según necesidad

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_arduino")
    private Arduino arduino;
}
