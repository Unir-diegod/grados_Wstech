package com.wastech.uni.registro.entity;

import com.wastech.uni.deshidratador.entity.Deshidratador;
import com.wastech.uni.materiaPrima.entity.TipoMateriaPrima;
import com.wastech.uni.compostaje.entity.TipoCompostaje;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entidad Registro (tabla resgistro).
 * Relaciones JPA:
 * - @ManyToOne con Deshidratador (ID_deshidratador)
 * - @ManyToOne con TipoMateriaPrima (ID_matep)
 * - @ManyToOne con TipoCompostaje (ID_compostaje)
 */
@Entity
@Table(name = "resgistro") // Respetando el typo del diagrama
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registro {

    @Id
    @Column(name = "ID_registro", nullable = false)
    private Long idRegistro;

    @Column(name = "Fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "Fecha_fin")
    private LocalDateTime fechaFin;

    @Column(name = "Estado", length = 50)
    private String estado;

    @Column(name = "Temperatura")
    private Double temperatura;

    @Column(name = "Humedad")
    private Double humedad;

    @Column(name = "cantidad")
    private Double cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_deshidratador")
    private Deshidratador deshidratador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_matep")
    private TipoMateriaPrima tipoMateriaPrima;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_compostaje")
    private TipoCompostaje tipoCompostaje;
}
