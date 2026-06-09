package com.wastech.uni.usuario.password;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class PasswordResetController {

    private final PasswordResetService passwordResetService;

    @GetMapping("/forgot-password")
    public String forgotPasswordForm() {
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String handleForgotPassword(@RequestParam String email, RedirectAttributes ra) {
        boolean ok = passwordResetService.createAndSendTokenForEmail(email);
        // Siempre redirigimos al formulario de restablecimiento para que el usuario pueda
        // pegar el código recibido y definir su nueva contraseña.
        ra.addFlashAttribute("info", "Si el correo está registrado, recibirás un código de recuperación. Pega ese código en el formulario para restablecer la contraseña.");
        return "redirect:/reset-password";
    }

    @GetMapping("/reset-password")
    public String resetPasswordForm(@RequestParam(required = false) String token, Model model) {
        model.addAttribute("token", token);
        return "reset-password";
    }

    @PostMapping("/reset-password")
    public String handleResetPassword(@RequestParam(required = false) String token,
                                      @RequestParam String password,
                                      RedirectAttributes ra) {
        if (token == null || token.isBlank()) {
            ra.addFlashAttribute("error", "Debes introducir el código de recuperación.");
            return "redirect:/reset-password";
        }

        boolean valid = passwordResetService.resetPassword(token.trim(), password);
        if (valid) {
            ra.addFlashAttribute("exito", "Contraseña actualizada correctamente. Ya puedes iniciar sesión.");
            return "redirect:/login";
        } else {
            ra.addFlashAttribute("error", "Código inválido o expirado.");
            return "redirect:/reset-password?token=" + token;
        }
    }
}
