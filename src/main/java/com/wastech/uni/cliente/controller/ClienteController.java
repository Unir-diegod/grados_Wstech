package com.wastech.uni.cliente.controller;

import com.wastech.uni.cliente.dto.ClienteDTO;
import com.wastech.uni.cliente.entity.Cliente;
import com.wastech.uni.cliente.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public String listarClientes(@RequestParam(required = false) String buscar, Model model) {
        model.addAttribute("clientes", clienteService.findByCedulaOrNombreOrApellido(buscar));
        model.addAttribute("buscar", buscar);
        return "clientes/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("clienteDTO", new ClienteDTO());
        model.addAttribute("edicion", false);
        return "clientes/formulario";
    }

    @PostMapping
    public String crearCliente(@Valid @ModelAttribute("clienteDTO") ClienteDTO clienteDTO, 
                               BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("edicion", false);
            return "clientes/formulario";
        }
        
        try {
            clienteService.save(clienteDTO);
            redirectAttributes.addFlashAttribute("exito", "Cliente creado correctamente.");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("edicion", false);
            return "clientes/formulario";
        }
        
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{cedula}")
    public String mostrarFormularioEdicion(@PathVariable String cedula, Model model, RedirectAttributes redirectAttributes) {
        try {
            Cliente cliente = clienteService.findById(cedula)
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
                    
            ClienteDTO dto = new ClienteDTO(
                    cliente.getCedula(),
                    cliente.getNombre1(),
                    cliente.getNombre2(),
                    cliente.getApellido1(),
                    cliente.getApellido2(),
                    cliente.getTelefono(),
                    cliente.getDireccion(),
                    cliente.getCorreo()
            );
            
            model.addAttribute("clienteDTO", dto);
            model.addAttribute("edicion", true);
            return "clientes/formulario";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al cargar el cliente para edición.");
            return "redirect:/clientes";
        }
    }

    @PostMapping("/actualizar/{cedula}")
    public String actualizarCliente(@PathVariable String cedula, 
                                    @Valid @ModelAttribute("clienteDTO") ClienteDTO clienteDTO, 
                                    BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("edicion", true);
            return "clientes/formulario";
        }
        
        try {
            clienteService.update(cedula, clienteDTO);
            redirectAttributes.addFlashAttribute("exito", "Cliente actualizado correctamente.");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("edicion", true);
            return "clientes/formulario";
        }
        
        return "redirect:/clientes";
    }

    @GetMapping("/ver/{cedula}")
    public String verDetalle(@PathVariable String cedula, Model model, RedirectAttributes redirectAttributes) {
        try {
            Cliente cliente = clienteService.findById(cedula)
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
            model.addAttribute("cliente", cliente);
            return "clientes/detalle";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Cliente no encontrado.");
            return "redirect:/clientes";
        }
    }
}
