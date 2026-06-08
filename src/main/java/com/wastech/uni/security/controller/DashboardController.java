package com.wastech.uni.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Obtener el usuario autenticado desde el contexto de Spring Security
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        // El nombre de usuario
        String username = auth.getName();
        
        // Obtener el primer rol (quitando el prefijo ROLE_)
        String role = auth.getAuthorities().stream()
                .findFirst()
                .map(grantedAuthority -> grantedAuthority.getAuthority().replace("ROLE_", ""))
                .orElse("DESCONOCIDO");

        // Pasar datos a la vista Thymeleaf
        model.addAttribute("username", username);
        model.addAttribute("role", role);
        model.addAttribute("fecha", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return "dashboard"; // Retorna dashboard.html
    }
}
