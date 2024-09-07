package com.itsqmet.desarrollo.servicios.impl;

import com.itsqmet.desarrollo.modelo.Curso;
import com.itsqmet.desarrollo.repositorio.ICursoRepositorio;
import com.itsqmet.desarrollo.servicio.ICursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServicioImpl implements ICursoServicio {

    @Autowired
    ICursoRepositorio cursoRepositorio;

    @Override
    public Curso saveCurso(Curso curso){
        return cursoRepositorio.save(curso);
    }

    @Override
    public Curso updateCurso(Curso curso){
        return cursoRepositorio.save(curso);
    }

    @Override
    public List<Curso> getCursos(){
        return cursoRepositorio.findAll();
    }

    @Override
    public Optional<Curso> getCursoById(int idCurso){
        return cursoRepositorio.findById(idCurso);
    }

    @Override
    public void deleteCurso(int idCurso){
        cursoRepositorio.deleteById(idCurso);
    }

}
