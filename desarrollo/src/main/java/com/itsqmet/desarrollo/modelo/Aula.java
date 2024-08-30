package com.itsqmet.desarrollo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAula;
    private int numero;

    @OneToOne
    @JoinColumn(name = "fkCurso")
    private Curso curso;

}
