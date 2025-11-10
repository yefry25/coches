package com.gestion.coches.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gestion.coches.Entities.Cliente;
import com.gestion.coches.Service.ClienteService;

import lombok.*;

@Controller
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public String listar(Model m) {
        var clientes = clienteService.listarTodos();

        m.addAttribute("clientes", clientes);
        return "listaClientes";
    }

    @GetMapping({ "/nuevo", "/editar/{id}" })
    public String form(@PathVariable(required = false) Long id, Model m) {
        m.addAttribute("cliente", id == null ? new Cliente() : clienteService.obtenerPorId(id));
        return "clienteFormulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute Cliente p, BindingResult r) {
        if (r.hasErrors())
            return "formulario";
        clienteService.guardar(p);
        return "redirect:/clientes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        var cliente = clienteService.obtenerPorId(id);
        cliente.setEliminado(true);

        clienteService.guardar(cliente);
        return "redirect:/clientes";
    }
}
