package com.itsqmet.desarrollo.servicios.impl;

import com.itsqmet.desarrollo.modelo.Estudiante;
import com.itsqmet.desarrollo.repositorio.IEstudianteRepositorio;
import com.itsqmet.desarrollo.servicio.IEstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicioImpl implements IEstudianteServicio {

    @Autowired
    IEstudianteRepositorio estudianteRepositorio;

    @Override
    public Estudiante saveEstudiante(Estudiante estudiante){
        return estudianteRepositorio.save(estudiante);
    }

    @Override
    public Estudiante updateEstudiante(Estudiante estudiante){
        return estudianteRepositorio.save(estudiante);
    }

    @Override
    public List<Estudiante> getEstudiantes(){
        return estudianteRepositorio.findAll();
    }

    @Override
    public Optional<Estudiante> getEstudianteById(int idEstudiante){
        return estudianteRepositorio.findById(idEstudiante);
    }

    @Override
    public void deleteEstudiante(int idEstudiante){
        estudianteRepositorio.deleteById(idEstudiante);
    }

}
