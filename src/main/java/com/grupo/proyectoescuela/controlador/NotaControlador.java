package com.grupo.proyectoescuela.controlador;

import com.grupo.proyectoescuela.modelo.Nota;
import com.grupo.proyectoescuela.servicio.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaControlador {

    private final NotaServicio notaServicio;


    @Autowired
    public NotaControlador(NotaServicio notaServicio) {
        this.notaServicio = notaServicio;
    }

    @GetMapping
    public List<Nota> obtenerTodasLasNotas() {
        return notaServicio.obtenerTodasLasNotas();
    }

    @GetMapping("/{id}")
    public Nota obtenerNotaPorId(@PathVariable Long id) {
        return notaServicio.obtenerNotaPorId(id);
    }

    @PostMapping
    public Nota crearNota(@RequestBody Nota nota) {
        return notaServicio.guardarNota(nota);
    }

    @PutMapping("/{id}")
    public Nota actualizarNota(@PathVariable Long id, @RequestBody Nota nota) {
        nota.setId(id);
        return notaServicio.guardarNota(nota);
    }

    @DeleteMapping("/{id}")
    public void eliminarNota(@PathVariable Long id) {
        notaServicio.eliminarNota(id);
    }

        
}
