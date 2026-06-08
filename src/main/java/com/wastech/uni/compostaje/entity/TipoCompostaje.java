package com.wastech.uni.compostaje.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad TipoCompostaje.
 * Relación JPA:
 * - Es referenciada por Registro a través de ID_compostaje.
 * - Un TipoCompostaje puede tener múltiples registros asociados (1:N).
 */
@Entity
@Table(name = "tipo_compostaje")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoCompostaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_compostaje", nullable = false)
    private Long idCompostaje;

    @NotBlank(message = "Los compuestos no pueden estar vacíos")
    @Size(max = 200, message = "Los compuestos no pueden exceder los 200 caracteres")
    @Column(name = "Compuestos", length = 200, nullable = false)
    private String compuestos;

    @DecimalMin(value = "0.0", message = "La temperatura límite no puede ser negativa")
    @Column(name = "temperatura_liminte")
    private Double temperaturaLiminte; // Nombre de columna respeta el diagrama original

    @DecimalMin(value = "0.0", message = "La humedad límite no puede ser negativa")
    @DecimalMax(value = "100.0", message = "La humedad límite no puede superar el 100%")
    @Column(name = "humedad_limite")
    private Double humedadLimite;
}
