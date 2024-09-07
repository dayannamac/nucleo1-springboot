package com.itsqmet.desarrollo.repositorio;

import com.itsqmet.desarrollo.modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudianteRepositorio extends JpaRepository<Estudiante, Integer> {
}
