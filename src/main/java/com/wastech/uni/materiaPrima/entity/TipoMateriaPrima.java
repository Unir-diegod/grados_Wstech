package com.wastech.uni.materiaPrima.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad TipoMateriaPrima.
 * Relación JPA:
 * - Es referenciada por resgistro a través de ID_matep.
 */
@Entity
@Table(name = "tipo_materia_prima")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoMateriaPrima {

    @Id
    @Column(name = "ID_matep", nullable = false)
    private Long idMatep;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "temperatura")
    private Double temperatura;
}
