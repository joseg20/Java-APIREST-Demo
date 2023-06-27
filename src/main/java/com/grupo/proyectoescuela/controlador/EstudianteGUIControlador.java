package com.grupo.proyectoescuela.controlador;

import com.grupo.proyectoescuela.modelo.Estudiante;
import com.grupo.proyectoescuela.servicio.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EstudianteGUIControlador {

    private final EstudianteServicio estudianteServicio;

    @Autowired
    public EstudianteGUIControlador(EstudianteServicio estudianteServicio) {
        this.estudianteServicio = estudianteServicio;
    }

    @PostMapping("/crearEstudiante")
    public String crearEstudiante(@RequestParam("name") String name,
                                  @RequestParam("email") String email) {
        Estudiante estudiante = new Estudiante(name, email);
        estudianteServicio.guardarEstudiante(estudiante);
        return "redirect:/";
    }
}
