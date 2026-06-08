package com.wastech.uni.usuario.entity;

import com.wastech.uni.perfil.entity.Perfil;
import com.wastech.uni.cliente.entity.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad Usuario.
 * Relación JPA: 
 * - @ManyToOne con Perfil (IdPerfil).
 * - @ManyToOne con Cliente (La línea del diagrama tiene una pata de gallo en Usuario, apuntando a Cliente).
 */
@Entity
@Table(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @Column(name = "IDusuario", nullable = false)
    private Long idusuario;

    @Column(name = "Nombre", length = 100)
    private String nombre;

    @Column(name = "Apellido", length = 100)
    private String apellido;

    @Column(name = "Usuario", length = 50)
    private String usuario;

    @Column(name = "Contraseña", length = 255)
    private String contrasena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPerfil")
    private Perfil perfil;
    
    // Relación inferida de la línea gráfica: pata de gallo (many) en Usuario, hacia Cliente (1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cedula_Cliente")
    private Cliente cliente;
}
