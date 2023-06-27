package com.grupo.proyectoescuela.controlador;

import com.grupo.proyectoescuela.modelo.Estudiante;
import com.grupo.proyectoescuela.servicio.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControlador {

    private final EstudianteServicio estudianteServicio;

    @Autowired
    public EstudianteControlador(EstudianteServicio estudianteServicio) {
        this.estudianteServicio = estudianteServicio;
    }

    @GetMapping
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteServicio.obtenerTodosLosEstudiantes();
    }

    @GetMapping("/{id}")
    public Estudiante obtenerEstudiantePorId(@PathVariable Long id) {
        return estudianteServicio.obtenerEstudiantePorId(id);
    }

    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteServicio.guardarEstudiante(estudiante);
    }

    @PutMapping("/{id}")
    public Estudiante actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id);
        return estudianteServicio.guardarEstudiante(estudiante);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstudiante(@PathVariable Long id) {
        estudianteServicio.eliminarEstudiante(id);
    }
}
