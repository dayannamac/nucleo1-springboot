package com.itsqmet.desarrollo.controlador;

import com.itsqmet.desarrollo.modelo.Matricula;
import com.itsqmet.desarrollo.servicios.impl.MatriculaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matricula")
public class MatriculaControlador {

    @Autowired
    MatriculaServicioImpl matriculaServicioImpl;

    @PostMapping
    public ResponseEntity<Matricula> saveMatriculaa (@RequestBody Matricula matricula){
        try {
            Matricula savedMatricula = matriculaServicioImpl.saveMatricula(matricula);
            return new ResponseEntity<>(savedMatricula, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Matricula> updateMatricula(@RequestBody Matricula matricula){
        try {
            Matricula updatedMatricula = matriculaServicioImpl.updateMatricula(matricula);
            return new ResponseEntity<>(updatedMatricula, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> getAllMatriculas(){
        return new ResponseEntity<>(matriculaServicioImpl.getMatriculas(), HttpStatus.OK);
    }

    @GetMapping("/{idMatricula}")
    public ResponseEntity<Matricula> getMatriculaById(@PathVariable int idMatricula){
        Optional<Matricula> matricula = matriculaServicioImpl.getMatriculaById(idMatricula);
        return matricula.map(value-> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idMatricula}")
    public ResponseEntity<Void> deleteMatricula(@PathVariable int idMatricula){
        Optional<Matricula> matricula = matriculaServicioImpl.getMatriculaById(idMatricula);
        if(matricula.isPresent()){
            matriculaServicioImpl.deleteMatricula(matricula.get().getIdMatricula());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
