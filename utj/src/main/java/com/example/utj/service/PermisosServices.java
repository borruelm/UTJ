package com.example.utj.service;

import com.example.utj.entity.PermisosResponse;

import java.util.List;

public interface PermisosServices {
    List<PermisosResponse> getAllPermisos();

    List<PermisosResponse> getAllByStatus(Integer estado);

    List<PermisosResponse> getAllByUsuario(Integer Usuario);

    List<PermisosResponse> getAllByUsuarioAndStatus(Integer Usuario, Integer estado);
}
