package com.example.utj.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy
            = GenerationType.AUTO)
    private Integer idusuario;
    private Integer id;
    private String nombre;
    private String correoElectronico;
    private String contrasena;
    private int rol;
    private int telefono;
    private int tiempoServicio;
    private String direccion;
    private String foto;
}
