package com.wastech.uni.usuario.controller;

import com.wastech.uni.cliente.service.ClienteService;
import com.wastech.uni.perfil.service.PerfilService;
import com.wastech.uni.usuario.dto.UsuarioDTO;
import com.wastech.uni.usuario.entity.Usuario;
import com.wastech.uni.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PerfilService perfilService;
    private final ClienteService clienteService;

    @GetMapping
    public String listarUsuarios(@RequestParam(required = false) String buscar, Model model) {
        model.addAttribute("usuarios", usuarioService.findByNombreOrUsuario(buscar));
        model.addAttribute("buscar", buscar);
        return "usuarios/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model) {
        cargarListasParaVista(model);
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        model.addAttribute("edicion", false);
        return "usuarios/formulario";
    }

    @PostMapping
    public String crearUsuario(@Valid @ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO, 
                               BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            cargarListasParaVista(model);
            model.addAttribute("edicion", false);
            return "usuarios/formulario";
        }
        
        try {
            usuarioService.save(usuarioDTO);
            redirectAttributes.addFlashAttribute("exito", "Usuario creado correctamente.");
        } catch (Exception e) {
            cargarListasParaVista(model);
            model.addAttribute("error", e.getMessage());
            model.addAttribute("edicion", false);
            return "usuarios/formulario";
        }
        
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Usuario usuario = usuarioService.findById(id)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
                    
            UsuarioDTO dto = new UsuarioDTO(
                    usuario.getIdusuario(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getUsuario(),
                    "", // La contraseña no se envía a la vista
                    usuario.getPerfil().getIdperfil(),
                    usuario.getCliente() != null ? usuario.getCliente().getCedula() : null
            );
            
            cargarListasParaVista(model);
            model.addAttribute("usuarioDTO", dto);
            model.addAttribute("edicion", true);
            return "usuarios/formulario";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al cargar el usuario para edición.");
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarUsuario(@PathVariable Long id, 
                                    @Valid @ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO, 
                                    BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        // Ignorar el error de la contraseña en edición si está vacía
        if (result.hasFieldErrors("contrasena") && (usuarioDTO.getContrasena() == null || usuarioDTO.getContrasena().isEmpty())) {
            // No hacemos nada, es válido dejarla vacía en edición
        } else if (result.hasErrors() && result.getErrorCount() > (result.hasFieldErrors("contrasena") ? 1 : 0)) {
            cargarListasParaVista(model);
            model.addAttribute("edicion", true);
            return "usuarios/formulario";
        }
        
        try {
            usuarioService.update(id, usuarioDTO);
            redirectAttributes.addFlashAttribute("exito", "Usuario actualizado correctamente.");
        } catch (Exception e) {
            cargarListasParaVista(model);
            model.addAttribute("error", e.getMessage());
            model.addAttribute("edicion", true);
            return "usuarios/formulario";
        }
        
        return "redirect:/usuarios";
    }

    @GetMapping("/ver/{id}")
    public String verDetalle(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Usuario usuario = usuarioService.findById(id)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            model.addAttribute("usuarioObj", usuario); // Para no chocar con "usuario" de sesión
            return "usuarios/detalle";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Usuario no encontrado.");
            return "redirect:/usuarios";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.deleteById(id);
            redirectAttributes.addFlashAttribute("exito", "Usuario eliminado correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/usuarios";
    }

    private void cargarListasParaVista(Model model) {
        model.addAttribute("perfiles", perfilService.findAll());
        model.addAttribute("clientes", clienteService.findAll());
    }
}
