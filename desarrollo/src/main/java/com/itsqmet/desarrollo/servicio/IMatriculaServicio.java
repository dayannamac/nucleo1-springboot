package com.itsqmet.desarrollo.servicio;

import com.itsqmet.desarrollo.modelo.Matricula;

import java.util.List;
import java.util.Optional;

public interface IMatriculaServicio {

    Matricula saveMatricula (Matricula matricula);

    Matricula updateMatricula (Matricula matricula);

    List<Matricula> getMatriculas();

    Optional<Matricula> getMatriculaById(int idMatricula);

    void deleteMatricula(int idMatricula);

}
