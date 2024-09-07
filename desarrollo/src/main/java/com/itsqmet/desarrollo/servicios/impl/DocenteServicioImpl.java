package com.itsqmet.desarrollo.servicios.impl;

import com.itsqmet.desarrollo.modelo.Docente;
import com.itsqmet.desarrollo.repositorio.IDocenteRepositorio;
import com.itsqmet.desarrollo.servicio.IDocenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServicioImpl implements IDocenteServicio {

    @Autowired
    IDocenteRepositorio docenteRepositorio;

    @Override
    public Docente saveDocente(Docente docente){
        return docenteRepositorio.save(docente);
    }

    @Override
    public Docente updateDocente(Docente docente){
        return docenteRepositorio.save(docente);
    }

    @Override
    public List<Docente>getDocentes(){
        return docenteRepositorio.findAll();
    }

    @Override
    public Optional<Docente> getDocenteById(int idDocente){
        return docenteRepositorio.findById(idDocente);
    }

    @Override
    public void deleteDocente(int idDocente){
        docenteRepositorio.deleteById(idDocente);
    }

}
