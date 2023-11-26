package com.example.utj.service.imp;

import com.example.utj.entity.Permiso;
import com.example.utj.entity.PermisosResponse;
import com.example.utj.repository.PermisoRepository;
import com.example.utj.service.PermisosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermisosServicesImpl implements PermisosServices {

    @Autowired
    private PermisoRepository permisoRepository;
    PermisosResponse mockPermisos = new PermisosResponse();


    public List<PermisosResponse> getAllPermisos(){
        List<PermisosResponse> permisosFound = new ArrayList<>();
        PermisosResponse myPermisos = new PermisosResponse();

        List<Permiso> foundPerm = permisoRepository.findAll();

        mockPermisos.setIdpermiso(1);
        mockPermisos.setEstado("pendiente");
        mockPermisos.setUsuarioName("Martin");
        permisosFound.add(mockPermisos);
        mockPermisos.setIdpermiso(2);
        mockPermisos.setEstado("pendiente");
        mockPermisos.setUsuarioName("Miguel");
        permisosFound.add(mockPermisos);


        return permisosFound;
    }

    public List<PermisosResponse> getAllByStatus(Integer estado){
        List<PermisosResponse> permisosFound = new ArrayList<>();
        PermisosResponse myPermisos = new PermisosResponse();


        return permisosFound;
    }
    public List<PermisosResponse> getAllByUsuario(Integer Usuario){
        List<PermisosResponse> permisosFound = new ArrayList<>();
        PermisosResponse myPermisos = new PermisosResponse();


        return permisosFound;
    }

    public List<PermisosResponse> getAllByUsuarioAndStatus(Integer Usuario, Integer estado){
        List<PermisosResponse> permisosFound = new ArrayList<>();
        PermisosResponse myPermisos = new PermisosResponse();


        return permisosFound;
    }
}
