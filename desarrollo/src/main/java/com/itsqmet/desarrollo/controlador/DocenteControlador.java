package com.itsqmet.desarrollo.controlador;

import com.itsqmet.desarrollo.modelo.Docente;
import com.itsqmet.desarrollo.servicios.impl.DocenteServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/docente")
public class DocenteControlador {

    @Autowired
    DocenteServicioImpl docenteServicioImpl;

    @PostMapping
    public ResponseEntity<Docente>saveDocente(@RequestBody Docente docente){
        try {
            Docente savedDocente = docenteServicioImpl.saveDocente(docente);
            return new ResponseEntity<>(savedDocente, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Docente>updateDocente(@RequestBody Docente docente){
        try {
            Docente updatedDocente = docenteServicioImpl.updateDocente(docente);
            return new ResponseEntity<>(updatedDocente, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Docente>>getAllDocentes(){
        return new ResponseEntity<>(docenteServicioImpl.getDocentes(), HttpStatus.OK);
    }

    @GetMapping("/{idDocente}")
    public ResponseEntity<Docente>getDocenteById(@PathVariable int idDocente){
        Optional<Docente> docente = docenteServicioImpl.getDocenteById(idDocente);
        return docente.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idDocente}")
    public ResponseEntity<Void>deleteDocente(@PathVariable int idDocente){
        Optional<Docente> docente = docenteServicioImpl.getDocenteById(idDocente);
        if(docente.isPresent()){
            docenteServicioImpl.deleteDocente(docente.get().getIdDocente());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
