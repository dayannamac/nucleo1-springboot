package com.itsqmet.desarrollo.repositorio;

import com.itsqmet.desarrollo.modelo.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepositorio extends JpaRepository<Docente, Integer> {
}
