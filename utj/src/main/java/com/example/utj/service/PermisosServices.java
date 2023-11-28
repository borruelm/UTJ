package com.example.utj.service;

import com.example.utj.entity.Permiso;
import com.example.utj.entity.PermisoRequest;
import com.example.utj.entity.PermisosResponse;

import java.text.ParseException;
import java.util.List;

public interface PermisosServices {
    List<Permiso> getAllPermisos();

    List<Permiso> getUsrPermisos(Integer usrId);

    List<PermisosResponse> getAllByStatus(Integer estado);

    List<PermisosResponse> getAllByUsuario(Integer Usuario);

    List<PermisosResponse> getAllByUsuarioAndStatus(Integer Usuario, Integer estado);

    String savePermiso(PermisoRequest newPermiso) throws ParseException;

    String modificarPermiso(Integer idPermiso, String accion);
    }
