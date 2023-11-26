package com.example.utj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Permiso {
    private Date diasolicitado;
    private String estado;
    private Date fechasolicitud;
    private Integer iddocumento;
    @Id
    @GeneratedValue(strategy
            = GenerationType.AUTO)
    private Integer idpermiso;
    private String nombre;
}
