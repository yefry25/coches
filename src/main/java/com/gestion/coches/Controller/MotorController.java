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
    public String listar(Model m) {
        m.addAttribute("motores", motorService.listarTodos());
        return "listaMotor";
    }

    @GetMapping({ "/nuevo", "/editar/{id}" })
    public String form(@PathVariable(required = false) Long id, Model m) {
        m.addAttribute("motor", id == null ? new Motor() : motorService.obtenerPorId(id));
        return "motorFormulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute Motor p, BindingResult r) {
        if (r.hasErrors())
            return "formulario";
        motorService.guardar(p);
        return "redirect:/motor";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        motorService.eliminar(id);
        return "redirect:/motor";
    }
}
