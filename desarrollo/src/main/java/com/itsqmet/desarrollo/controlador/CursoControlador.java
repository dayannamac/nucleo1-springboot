package com.itsqmet.desarrollo.controlador;

import com.itsqmet.desarrollo.modelo.Curso;
import com.itsqmet.desarrollo.servicios.impl.CursoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoControlador {

    @Autowired
    CursoServicioImpl cursoServicioImpl;

    @PostMapping
    public ResponseEntity<Curso> saveCurso(@RequestBody Curso curso){
        try {
            Curso savedCurso = cursoServicioImpl.saveCurso(curso);
            return new ResponseEntity<>(savedCurso, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso){
        try {
            Curso updatedCurso = cursoServicioImpl.updateCurso(curso);
            return new ResponseEntity<>(updatedCurso, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Curso>>getAllCursos(){
        return new ResponseEntity<>(cursoServicioImpl.getCursos(), HttpStatus.OK);
    }

    @GetMapping("/{idCurso}")
    public ResponseEntity<Curso>getCursoById(@PathVariable int idCurso){
        Optional<Curso> curso = cursoServicioImpl.getCursoById(idCurso);
        return curso.map(value-> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idCurso}")
    public ResponseEntity<Void>deleteCurso(@PathVariable int idCurso){
        Optional<Curso> curso = cursoServicioImpl.getCursoById(idCurso);
        if (curso.isPresent()){
            cursoServicioImpl.deleteCurso(curso.get().getIdCurso());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
