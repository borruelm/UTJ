package com.example.utj.entity;

import lombok.Data;

import java.util.Date;
@Data
public class PermisoRequest {
    private Integer idpermiso;
    private String nombre;
    private String fechasolicitud;
    private String  fechainicio;
    private String  fechafin;
    private String estado;
    private Integer usuarioIdusuario;
    private  Integer rolIdRol;
    private String tipo;
}
