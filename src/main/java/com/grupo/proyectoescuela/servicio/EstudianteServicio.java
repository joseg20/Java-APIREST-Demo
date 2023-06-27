package com.grupo.proyectoescuela.servicio;

import com.grupo.proyectoescuela.modelo.Estudiante;
import com.grupo.proyectoescuela.repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServicio {

    private final EstudianteRepositorio estudianteRepositorio;

    @Autowired
    public EstudianteServicio(EstudianteRepositorio estudianteRepositorio) {
        this.estudianteRepositorio = estudianteRepositorio;
    }

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepositorio.findAll();
    }

    public Estudiante obtenerEstudiantePorId(Long id) {
        return estudianteRepositorio.findById(id).orElse(null);
    }

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepositorio.save(estudiante);
    }

    public void eliminarEstudiante(Long id) {
        estudianteRepositorio.deleteById(id);
    }
}
