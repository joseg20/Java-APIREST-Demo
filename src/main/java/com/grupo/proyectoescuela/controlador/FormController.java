package com.grupo.proyectoescuela.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {
    
    @GetMapping("/formEstudiante")
    public String formEstudiante() {
        return "formEstudiante";
    }

    @GetMapping("/formNota")
    public String formNota() {
        return "formNota";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

}
