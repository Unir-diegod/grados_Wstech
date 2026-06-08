package com.wastech.uni.usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long idusuario; // Para edición

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 100, message = "El apellido no puede exceder los 100 caracteres")
    private String apellido;

    @NotBlank(message = "El usuario no puede estar vacío")
    @Size(max = 50, message = "El usuario no puede exceder los 50 caracteres")
    private String usuario;

    // La contraseña puede ser vacía en la edición (significa que no se cambia)
    @Size(max = 255, message = "La contraseña no puede exceder los 255 caracteres")
    private String contrasena;

    @NotNull(message = "El perfil es obligatorio")
    private Long idperfil;

    private String cedulaCliente; // Puede ser nulo
}
