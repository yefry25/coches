package com.gestion.coches.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gestion.coches.Entities.Motor;
import com.gestion.coches.Service.MotorService;

import lombok.*;

@Controller
@RequestMapping("/motor")
@RequiredArgsConstructor
public class MotorController {

    private final MotorService motorService;

    @GetMapping
    public void listar(Model m) {
        m.addAttribute("motor", motorService.listarTodos());
        // return "lista";
    }

    @GetMapping({ "/nuevo", "/editar/{id}" })
    public String form(@PathVariable(required = false) Long id, Model m) {
        m.addAttribute("motor", id == null ? new Motor() : motorService.obtenerPorId(id));
        return "formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute Motor p, BindingResult r) {
        if (r.hasErrors())
            return "formulario";
        motorService.guardar(p);
        return "redirect:/motor";
    }
}
