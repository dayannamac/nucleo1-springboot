package com.itsqmet.desarrollo.controlador;

import com.itsqmet.desarrollo.modelo.Estudiante;
import com.itsqmet.desarrollo.servicios.impl.EstudianteServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiante")
public class EstudianteControlador {

    @Autowired
    EstudianteServicioImpl estudianteServicioImpl;

    @PostMapping //agregar datos en la entidad
    public ResponseEntity<Estudiante> saveEstudiante(@RequestBody Estudiante estudiante){
        try {
            Estudiante savedEstudiante = estudianteServicioImpl.saveEstudiante(estudiante);
            return new ResponseEntity<>(savedEstudiante, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping //editar datos de la entidad
    public ResponseEntity<Estudiante> updateEstudiante(@RequestBody Estudiante estudiante){
        try {
            Estudiante updatedEstudiante = estudianteServicioImpl.updateEstudiante(estudiante);
            return new ResponseEntity<>(updatedEstudiante, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping //traer la lista de los datos registrados en la entidad
    public ResponseEntity<List<Estudiante>> getAllEstudiantes(){
        return new ResponseEntity<>(estudianteServicioImpl.getEstudiantes(), HttpStatus.OK);
    }

    @GetMapping("/{idEstudiante}") //buscar datos en la entidad por id
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable int idEstudiante){
        Optional<Estudiante> estudiante = estudianteServicioImpl.getEstudianteById(idEstudiante);
        return estudiante.map(value->new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idEstudiante}") //eliminar datos en la entidad por id
    public ResponseEntity<Void> deleteEstudiante(@PathVariable int idEstudiante){
        Optional<Estudiante> estudiante = estudianteServicioImpl.getEstudianteById(idEstudiante);
        if (estudiante.isPresent()){
           estudianteServicioImpl.deleteEstudiante(estudiante.get().getIdEstudiante());
           return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
