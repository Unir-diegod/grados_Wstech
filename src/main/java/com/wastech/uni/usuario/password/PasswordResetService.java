package com.wastech.uni.usuario.password;

public interface PasswordResetService {
    /** Crea un código para el usuario asociado al email y lo envía. Retorna true si se encontró usuario. */
    boolean createAndSendTokenForEmail(String email);

    /** Valida que el token sea válido (exista, no usado, no expirado). */
    boolean validateToken(String token);

    /** Consume el token y actualiza la contraseña del usuario. */
    boolean resetPassword(String token, String newPassword);
}
