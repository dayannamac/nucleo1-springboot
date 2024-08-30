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

    @ManyToOne
    @JoinColumn(name = "fkDocente")
    private Docente docente;

}
