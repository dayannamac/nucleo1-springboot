package com.itsqmet.desarrollo.servicios.impl;

import com.itsqmet.desarrollo.modelo.Matricula;
import com.itsqmet.desarrollo.repositorio.IMatriculaRepositorio;
import com.itsqmet.desarrollo.servicio.IMatriculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServicioImpl implements IMatriculaServicio {

    @Autowired
    IMatriculaRepositorio matriculaRepositorio;

    @Override
    public Matricula saveMatricula (Matricula matricula){
        return matriculaRepositorio.save(matricula);
    }

    @Override
    public Matricula updateMatricula (Matricula matricula){
        return matriculaRepositorio.save(matricula);
    }

    @Override
    public List<Matricula> getMatriculas(){
        return matriculaRepositorio.findAll();
    }

    @Override
    public Optional<Matricula> getMatriculaById(int idMatricula){
        return matriculaRepositorio.findById(idMatricula);
    }

    @Override
    public void deleteMatricula(int idMatricula){
        matriculaRepositorio.deleteById(idMatricula);
    }

}
