package com.itsqmet.desarrollo.servicio;

import com.itsqmet.desarrollo.modelo.Docente;

import java.util.List;
import java.util.Optional;

public interface IDocenteServicio {

    Docente saveDocente (Docente docente);

    Docente updateDocente (Docente docente);

    List<Docente> getDocentes();

    Optional<Docente>getDocenteById(int idDocente);

    void deleteDocente(int idDocente);

}
