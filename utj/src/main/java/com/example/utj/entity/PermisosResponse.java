package com.example.utj.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PermisosResponse {
    private Date diasolicitado;
    private String estado;
    private Date fechaSolicitud;
    private Integer iddocumento;
    private Integer idpermiso;
    private String usuarioName;
}
