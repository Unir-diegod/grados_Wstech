package com.wastech.uni.registro.entity;

import com.wastech.uni.deshidratador.entity.Deshidratador;
import com.wastech.uni.materiaPrima.entity.TipoMateriaPrima;
import com.wastech.uni.compostaje.entity.TipoCompostaje;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entidad Registro (tabla resgistro).
 * Relaciones JPA:
 * - @ManyToOne con Deshidratador (ID_deshidratador): Un registro pertenece a un deshidratador.
 * - @ManyToOne con TipoMateriaPrima (ID_matep): Un registro usa un tipo de materia prima.
 * - @ManyToOne con TipoCompostaje (ID_compostaje): Un registro tiene un tipo de compostaje.
 * - @OneToMany inverso: Un Registro puede tener muchos Clientes asociados.
 */
@Entity
@Table(name = "resgistro") // Nombre de tabla respeta el diagrama original
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_registro", nullable = false)
    private Long idRegistro;

    @Column(name = "Fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "Fecha_fin")
    private LocalDateTime fechaFin;

    @NotBlank(message = "El estado no puede estar vacío")
    @Size(max = 50, message = "El estado no puede exceder los 50 caracteres")
    @Column(name = "Estado", length = 50, nullable = false)
    private String estado;

    @DecimalMin(value = "0.0", message = "La temperatura no puede ser negativa")
    @Column(name = "Temperatura")
    private Double temperatura;

    @DecimalMin(value = "0.0", message = "La humedad no puede ser negativa")
    @Column(name = "Humedad")
    private Double humedad;

    @DecimalMin(value = "0.0", message = "La cantidad no puede ser negativa")
    @Column(name = "cantidad")
    private Double cantidad;

    @NotNull(message = "El deshidratador es obligatorio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_deshidratador", nullable = false)
    private Deshidratador deshidratador;

    @NotNull(message = "El tipo de materia prima es obligatorio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_matep", nullable = false)
    private TipoMateriaPrima tipoMateriaPrima;

    @NotNull(message = "El tipo de compostaje es obligatorio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_compostaje", nullable = false)
    private TipoCompostaje tipoCompostaje;
}
