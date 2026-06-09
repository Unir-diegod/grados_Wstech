package com.wastech.uni.security.controller;

import com.wastech.uni.cliente.entity.Cliente;
import com.wastech.uni.cliente.repository.ClienteRepository;
import com.wastech.uni.exception.BusinessException;
import com.wastech.uni.perfil.entity.Perfil;
import com.wastech.uni.perfil.repository.PerfilRepository;
import com.wastech.uni.security.dto.RegistroCuentaDTO;
import com.wastech.uni.usuario.entity.Usuario;
import com.wastech.uni.usuario.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("cuentaRegistroController")
@RequiredArgsConstructor
public class RegistroController {

    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("registroCuentaDTO", new RegistroCuentaDTO());
        return "registro";
    }

    @PostMapping("/registro")
    @Transactional
    public String registrarCuenta(
            @Valid @ModelAttribute("registroCuentaDTO") RegistroCuentaDTO dto,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            return "registro";
        }

        try {
            validarRegistro(dto);

            Cliente cliente = new Cliente();
            cliente.setCedula(dto.getCedula().trim());
            cliente.setNombre1(dto.getNombre1().trim());
            cliente.setNombre2(vacioANulo(dto.getNombre2()));
            cliente.setApellido1(dto.getApellido1().trim());
            cliente.setApellido2(vacioANulo(dto.getApellido2()));
            cliente.setTelefono(vacioANulo(dto.getTelefono()));
            cliente.setDireccion(vacioANulo(dto.getDireccion()));
            cliente.setCorreo(vacioANulo(dto.getCorreo()));
            Cliente clienteGuardado = clienteRepository.save(cliente);

                Perfil perfilCliente = perfilRepository.findFirstByNombreOrderByIdperfilAsc("CLIENTE")
                    .orElseThrow(() -> new BusinessException("No existe el perfil CLIENTE configurado."));

            Usuario usuario = new Usuario();
            usuario.setNombre(construirNombre(dto));
            usuario.setApellido(construirApellido(dto));
            usuario.setUsuario(dto.getUsuario().trim());
            usuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));
            usuario.setPerfil(perfilCliente);
            usuario.setCliente(clienteGuardado);
            usuarioRepository.save(usuario);

            redirectAttributes.addFlashAttribute("registroExitoso", "Cuenta creada correctamente. Ahora puedes iniciar sesión.");
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "registro";
        }
    }

    private void validarRegistro(RegistroCuentaDTO dto) {
        String cedula = dto.getCedula().trim();
        String usuario = dto.getUsuario().trim();

        if (clienteRepository.existsById(cedula)) {
            throw new BusinessException("Ya existe una cuenta registrada con esa cédula.");
        }

        if (usuarioRepository.existsByUsuario(usuario)) {
            throw new BusinessException("El nombre de usuario ya está en uso.");
        }

        if (!dto.getContrasena().equals(dto.getConfirmarContrasena())) {
            throw new BusinessException("Las contraseñas no coinciden.");
        }

        String correo = vacioANulo(dto.getCorreo());
        if (correo != null && usuarioRepository.existsByClienteCorreo(correo)) {
            throw new BusinessException("Ya existe una cuenta registrada con ese correo.");
        }
    }

    private String construirNombre(RegistroCuentaDTO dto) {
        if (dto.getNombre2() == null || dto.getNombre2().trim().isEmpty()) {
            return dto.getNombre1().trim();
        }
        return dto.getNombre1().trim() + " " + dto.getNombre2().trim();
    }

    private String construirApellido(RegistroCuentaDTO dto) {
        if (dto.getApellido2() == null || dto.getApellido2().trim().isEmpty()) {
            return dto.getApellido1().trim();
        }
        return dto.getApellido1().trim() + " " + dto.getApellido2().trim();
    }

    private String vacioANulo(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        return value.trim();
    }
}
