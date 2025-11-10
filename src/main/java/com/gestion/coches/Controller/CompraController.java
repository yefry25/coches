package com.gestion.coches.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gestion.coches.Entities.*;
import com.gestion.coches.Service.*;

import lombok.*;

@Controller
@RequestMapping("/compras")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;
    private final ClienteService clienteService;
    private final CocheService cocheService;

    @GetMapping
    public String listar(Model m) {
        m.addAttribute("compras", compraService.listarTodos());
        return "listaCompra";
    }

    @GetMapping({ "/nuevo", "/editar/{id}" })
    public String form(@PathVariable(required = false) Long id, Model m) {
        m.addAttribute("compra", id == null ? new Compra() : compraService.obtenerPorId(id));

        m.addAttribute("clientes", clienteService.listarTodos());
        m.addAttribute("coches", cocheService.listarTodos());
        return "compraFormulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute Compra compra, BindingResult r) {
        if (r.hasErrors())
            return "compraFormulario";
        compraService.guardar(compra);
        return "redirect:/compras";
    }
}
