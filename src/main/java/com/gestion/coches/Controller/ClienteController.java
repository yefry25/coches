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
        m.addAttribute("clientes", clienteService.listarTodos());
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
        clienteService.eliminar(id);
        return "redirect:/clientes";
    }
}
