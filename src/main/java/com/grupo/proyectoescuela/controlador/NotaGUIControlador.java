package com.grupo.proyectoescuela.controlador;

import com.grupo.proyectoescuela.modelo.Estudiante;
import com.grupo.proyectoescuela.modelo.Nota;
import com.grupo.proyectoescuela.servicio.EstudianteServicio;
import com.grupo.proyectoescuela.servicio.NotaServicio;
import com.grupo.proyectoescuela.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotaGUIControlador {

    private final NotaServicio notaServicio;
    private final EstudianteServicio estudianteServicio;
    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    public NotaGUIControlador(NotaServicio notaServicio, EstudianteServicio estudianteServicio) {
        this.notaServicio = notaServicio;
        this.estudianteServicio = estudianteServicio;
    }

    @PostMapping("/subirNota")
    public String subirNota(@RequestParam("studentId") Long studentId,
                            @RequestParam("nota") Double nota) {
        Estudiante estudiante = estudianteServicio.obtenerEstudiantePorId(studentId);
        Nota nuevaNota = new Nota(estudiante, nota);
        notaServicio.guardarNota(nuevaNota);
        emailUtil.sendEmail(estudiante.getEmail(), "Tu puntuación ha sido actualizada", "Tu nueva puntuación es: " + nuevaNota.getNota());
        return "redirect:/";
    }
}
