package com.grupo.proyectoescuela.repositorio;

import com.grupo.proyectoescuela.modelo.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepositorio extends JpaRepository<Nota, Long> {
}
