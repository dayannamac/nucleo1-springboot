package com.itsqmet.desarrollo.servicios.impl;

import com.itsqmet.desarrollo.modelo.Aula;
import com.itsqmet.desarrollo.repositorio.IAulaRepositorio;
import com.itsqmet.desarrollo.servicio.IAulaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaServicioImpl implements IAulaServicio {

    @Autowired
    IAulaRepositorio aulaRepositorio;

    @Override
    public Aula saveAula(Aula aula){
        return aulaRepositorio.save(aula);
    }

    @Override
    public Aula updateAula(Aula aula){
        return aulaRepositorio.save(aula);
    }

    @Override
    public List<Aula> getAulas(){
        return aulaRepositorio.findAll();
    }

    @Override
    public Optional<Aula> getAulaById(int idAula){
        return aulaRepositorio.findById(idAula);
    }

    @Override
    public void deleteAula(int idAula){
        aulaRepositorio.deleteById(idAula);
    }

}
