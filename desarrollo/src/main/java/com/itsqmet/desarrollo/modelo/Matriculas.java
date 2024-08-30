package com.itsqmet.desarrollo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity

public class Matriculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMatriculas;
    private String nombre;
    private LocalDate fecha;

    @ManyToOne //Establecemos relacion Muchos a uno
    @JoinColumn(name="fkEstudiante") //le damos nombre a la llave foranea
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name="fkCurso")
    private Curso curso;

}
