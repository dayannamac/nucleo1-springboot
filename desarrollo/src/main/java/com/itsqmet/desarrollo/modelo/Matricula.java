package com.itsqmet.desarrollo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity

public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMatricula;

    private LocalDate fecha;

    @ManyToOne // Muchos estudiantes pueden estar en varias matriculas
    @JoinColumn(name="fkEstudiante") //le damos nombre a la llave foranea
    private Estudiante estudiante;

    @ManyToOne // Un curso puede tener muchos estudiantes matriculados
    @JoinColumn(name="fkCurso")
    private Curso curso;

}
