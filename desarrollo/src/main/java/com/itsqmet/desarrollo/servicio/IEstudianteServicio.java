package com.itsqmet.desarrollo.servicio;

import com.itsqmet.desarrollo.modelo.Estudiante;

import java.util.List;
import java.util.Optional;

public interface IEstudianteServicio {

    Estudiante saveEstudiante(Estudiante estudiante);

    Estudiante updateEstudiante(Estudiante estudiante);

    List<Estudiante> getEstudiantes();

    Optional<Estudiante> getEstudianteById(int idEstudiante);

    void deleteEstudiante(int idEstudiante);

}
