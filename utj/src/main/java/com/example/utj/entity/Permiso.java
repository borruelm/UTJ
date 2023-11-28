package com.example.utj.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Data
public class Permiso {
    @Id
    @GeneratedValue(strategy
            = GenerationType.AUTO)
    private Integer idpermiso;
    private String nombre;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechasolicitud;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechainicio;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechafin;
    private String estado;
    private Integer usuarioIdusuario;
    private Integer rolIdrol;
    private String tipo;
//    private Integer iddocumento;
}
