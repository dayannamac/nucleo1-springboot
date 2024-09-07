package com.itsqmet.desarrollo.controlador;

import com.itsqmet.desarrollo.modelo.Aula;
import com.itsqmet.desarrollo.servicios.impl.AulaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aula")
public class AulaControlador {

    @Autowired
    AulaServicioImpl aulaServicioImpl;

    @PostMapping
    public ResponseEntity<Aula>saveAula(@RequestBody Aula aula){
        try {
            Aula savedAula = aulaServicioImpl.saveAula(aula);
            return new ResponseEntity<>(savedAula, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Aula>updateAula(@RequestBody Aula aula){
        try {
            Aula updatedAula = aulaServicioImpl.updateAula(aula);
            return new ResponseEntity<>(updatedAula, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Aula>>getAllAulas(){
        return new ResponseEntity<>(aulaServicioImpl.getAulas(), HttpStatus.OK);
    }

    @GetMapping("/{idAula}")
    public ResponseEntity<Aula> getAulaById(@PathVariable int idAula){
        Optional<Aula> aula = aulaServicioImpl.getAulaById(idAula);
        return aula.map(value->new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idAula}")
    public ResponseEntity<Aula> deleteAula(@PathVariable int idAula){
        Optional<Aula> aula = aulaServicioImpl.getAulaById(idAula);
        if(aula.isPresent()){
            aulaServicioImpl.deleteAula(aula.get().getIdAula());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
