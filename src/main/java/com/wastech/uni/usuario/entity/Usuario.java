package com.wastech.uni.usuario.entity;

import com.wastech.uni.perfil.entity.Perfil;
import com.wastech.uni.cliente.entity.Cliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad Usuario.
 * Relación JPA: 
 * - @ManyToOne con Perfil (IdPerfil): Un usuario pertenece a un perfil.
 * - @ManyToOne con Cliente (Cedula_Cliente): Un usuario puede estar asociado a un cliente.
 */
@Entity
@Table(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDusuario", nullable = false)
    private Long idusuario;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    @Column(name = "Nombre", length = 100, nullable = false)
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 100, message = "El apellido no puede exceder los 100 caracteres")
    @Column(name = "Apellido", length = 100, nullable = false)
    private String apellido;

    @NotBlank(message = "El usuario no puede estar vacío")
    @Size(max = 50, message = "El usuario no puede exceder los 50 caracteres")
    @Column(name = "Usuario", length = 50, nullable = false, unique = true)
    private String usuario;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(max = 255, message = "La contraseña no puede exceder los 255 caracteres")
    @Column(name = "Contraseña", length = 255, nullable = false)
    private String contrasena;

    @NotNull(message = "El perfil es obligatorio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPerfil", nullable = false)
    private Perfil perfil;
    
    // Relación hacia Cliente (asumiendo que puede ser nulo o no, si todos los usuarios no son clientes)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cedula_Cliente")
    private Cliente cliente;
}
