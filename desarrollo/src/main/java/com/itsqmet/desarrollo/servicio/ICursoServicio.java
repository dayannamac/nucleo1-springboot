package com.itsqmet.desarrollo.servicio;

import com.itsqmet.desarrollo.modelo.Curso;

import java.util.List;
import java.util.Optional;

public interface ICursoServicio {

    Curso saveCurso (Curso curso);

    Curso updateCurso (Curso curso);

    List<Curso> getCursos();

    Optional<Curso> getCursoById(int idCurso);

    void deleteCurso (int idCurso);

}
