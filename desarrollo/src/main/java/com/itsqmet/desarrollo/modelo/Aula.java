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

    @OneToOne(mappedBy = "aula")
    private Curso curso;

}
