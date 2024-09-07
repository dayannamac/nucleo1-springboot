package com.itsqmet.desarrollo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;
    private String nombre;

    @ManyToOne // Muchos cursos pueden ser impartidos por un docente
    @JoinColumn(name = "fkDocente")
    private Docente docente;

    @OneToOne  // Un curso está en una sola aula
    @JoinColumn(name = "fkAula")
    private Aula aula;

}
