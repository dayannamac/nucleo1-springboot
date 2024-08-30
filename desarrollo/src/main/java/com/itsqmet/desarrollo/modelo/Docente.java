package com.itsqmet.desarrollo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

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

}
