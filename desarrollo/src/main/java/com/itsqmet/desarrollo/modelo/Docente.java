package com.itsqmet.desarrollo.modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Entity

public class Docente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocente;
    private String nombre;
    private String apellido;
    private String correo;
    private String especialidad;

    @OneToMany(mappedBy = "docente")  // Un docente puede impartir varios cursos
    private List<Curso> cursos;
}
