package com.itsqmet.desarrollo.repositorio;

import com.itsqmet.desarrollo.modelo.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepositorio extends JpaRepository<Aula, Integer> {
}
