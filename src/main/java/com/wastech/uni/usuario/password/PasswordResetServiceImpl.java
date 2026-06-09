package com.wastech.uni.usuario.password;

import com.wastech.uni.usuario.entity.Usuario;
import com.wastech.uni.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PasswordResetServiceImpl implements PasswordResetService {

    private final PasswordResetTokenRepository tokenRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired(required = false)
    private JavaMailSender mailSender;

    private final Logger logger = LoggerFactory.getLogger(PasswordResetServiceImpl.class);

    private static final int EXPIRATION_MINUTES = 15;

    @Override
    @Transactional
    public boolean createAndSendTokenForEmail(String email) {
        // Buscar usuario por correo del cliente
        Optional<Usuario> usuarioOpt = usuarioRepository.findFirstByClienteCorreoOrderByIdusuarioAsc(email);
        if (usuarioOpt.isEmpty()) {
            return false;
        }

        Usuario usuario = usuarioOpt.get();

        // Generar código numérico de 6 dígitos
        String code = String.format("%06d", new Random().nextInt(1_000_000));

        PasswordResetToken token = new PasswordResetToken();
        token.setToken(code);
        token.setUsuario(usuario);
        token.setExpiryDate(LocalDateTime.now().plusMinutes(EXPIRATION_MINUTES));
        token.setUsed(false);
        tokenRepository.save(token);

        // Envío de correo (si está configurado), si no, escribir en logs
        if (mailSender != null) {
            try {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(email);
                message.setSubject("Código de recuperación - Wastech");
                message.setText("Tu código de recuperación es: " + code + " (válido por " + EXPIRATION_MINUTES + " minutos)");
                mailSender.send(message);
                logger.info("Se envió código de recuperación por correo a {}", email);
            } catch (Exception e) {
                logger.warn("No se pudo enviar correo, mostrando código en logs: {}", code);
            }
        } else {
            logger.info("Código de recuperación para {} : {}", email, code);
        }

        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean validateToken(String token) {
        Optional<PasswordResetToken> t = tokenRepository.findByToken(token);
        if (t.isEmpty()) return false;
        PasswordResetToken prt = t.get();
        if (prt.isUsed()) return false;
        return prt.getExpiryDate().isAfter(LocalDateTime.now());
    }

    @Override
    @Transactional
    public boolean resetPassword(String token, String newPassword) {
        Optional<PasswordResetToken> t = tokenRepository.findByToken(token);
        if (t.isEmpty()) return false;
        PasswordResetToken prt = t.get();
        if (prt.isUsed() || prt.getExpiryDate().isBefore(LocalDateTime.now())) return false;

        Usuario usuario = prt.getUsuario();
        usuario.setContrasena(passwordEncoder.encode(newPassword));
        usuarioRepository.save(usuario);

        prt.setUsed(true);
        tokenRepository.save(prt);
        return true;
    }
}
