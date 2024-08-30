package com.itsqmet.desarrollo.repositorio;

import com.itsqmet.desarrollo.modelo.Matriculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculasRepositorio extends JpaRepository<Matriculas, Integer> {
}
