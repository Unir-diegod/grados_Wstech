package com.wastech.uni.compostaje.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad TipoCompostaje.
 * Relación JPA:
 * - Es referenciada por resgistro a través de ID_compostaje.
 */
@Entity
@Table(name = "tipo_compostaje")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoCompostaje {

    @Id
    @Column(name = "ID_compostaje", nullable = false)
    private Long idCompostaje;

    @Column(name = "Compuestos", length = 200)
    private String compuestos;

    @Column(name = "temperatura_liminte")
    private Double temperaturaLiminte; // Respetando el nombre de la imagen

    @Column(name = "humedad_limite")
    private Double humedadLimite;
}
