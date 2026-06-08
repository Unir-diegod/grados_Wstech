package com.wastech.uni.materiaPrima.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad TipoMateriaPrima.
 * Relación JPA:
 * - Es referenciada por Registro a través de ID_matep.
 * - Un TipoMateriaPrima puede estar en múltiples registros (1:N).
 */
@Entity
@Table(name = "tipo_materia_prima")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoMateriaPrima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_matep", nullable = false)
    private Long idMatep;

    @NotBlank(message = "El nombre de la materia prima no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @DecimalMin(value = "0.0", message = "La temperatura no puede ser negativa")
    @Column(name = "temperatura")
    private Double temperatura;
}
