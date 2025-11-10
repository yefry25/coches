package com.gestion.coches.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gestion.coches.Entities.*;
import com.gestion.coches.Service.*;

import lombok.*;

@Controller
@RequestMapping("/coches")
@RequiredArgsConstructor
public class CocheController
{
    private final CocheService cocheService;
    private final MotorService motorService;

    @GetMapping("/")
    public String home() {
        return "main";
    }

    @GetMapping
    public String listar(Model m) {
        m.addAttribute("coches", cocheService.listarTodos());
        m.addAttribute("motores", motorService.listarTodos());
        return "lista";
    }

    @GetMapping({"/nuevo", "/editar/{id}"})
    public String form(@PathVariable(required = false) Long id, Model m) {
        m.addAttribute("coche", id == null ? new Coche() : cocheService.obtenerPorId(id));
        System.out.println("Motores encontrados: " + motorService.listarTodos().size());
        m.addAttribute("motores", motorService.listarTodos());
        return "formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute Coche coche, BindingResult r) {
        if (r.hasErrors()) return "formulario";
        cocheService.guardar(coche);
        return "redirect:/coches";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        cocheService.eliminar(id);
        return "redirect:/coches";
    }
}
