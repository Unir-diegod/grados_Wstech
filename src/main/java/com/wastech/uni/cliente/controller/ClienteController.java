package com.wastech.uni.cliente.controller;

import com.wastech.uni.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Clientes.
 * Maneja las solicitudes HTTP relacionadas con la gestión de clientes.
 *
 * TODO (sprint gestión de clientes):
 *  - GET  /clientes          → listar todos los clientes
 *  - GET  /clientes/{cedula} → ver detalle de un cliente
 *  - GET  /clientes/nuevo    → formulario de creación
 *  - POST /clientes          → crear cliente
 *  - GET  /clientes/{cedula}/editar → formulario de edición
 *  - POST /clientes/{cedula} → actualizar cliente
 */
@Controller
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    // TODO: implementar endpoints en el sprint de gestión de clientes
}
