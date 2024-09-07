package com.itsqmet.desarrollo.repositorio;

import com.itsqmet.desarrollo.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepositorio extends JpaRepository<Curso, Integer> {
}
