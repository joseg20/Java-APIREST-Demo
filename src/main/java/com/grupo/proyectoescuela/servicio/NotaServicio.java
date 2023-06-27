package com.grupo.proyectoescuela.servicio;

import com.grupo.proyectoescuela.modelo.Nota;
import com.grupo.proyectoescuela.repositorio.NotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServicio {

    private final NotaRepositorio notaRepositorio;

    @Autowired
    public NotaServicio(NotaRepositorio notaRepositorio) {
        this.notaRepositorio = notaRepositorio;
    }

    public List<Nota> obtenerTodasLasNotas() {
        return notaRepositorio.findAll();
    }

    public Nota obtenerNotaPorId(Long id) {
        return notaRepositorio.findById(id).orElse(null);
    }

    public Nota guardarNota(Nota nota) {
        return notaRepositorio.save(nota);
    }

    public void eliminarNota(Long id) {
        notaRepositorio.deleteById(id);
    }
}
