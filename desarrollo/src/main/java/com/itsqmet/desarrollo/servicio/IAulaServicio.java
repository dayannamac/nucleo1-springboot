package com.itsqmet.desarrollo.servicio;

import com.itsqmet.desarrollo.modelo.Aula;

import java.util.List;
import java.util.Optional;

public interface IAulaServicio {

    Aula saveAula (Aula aula);

    Aula updateAula (Aula aula);

    List<Aula> getAulas();

    Optional<Aula> getAulaById(int idAula);

    void deleteAula(int idAula);

}
