package com.example.utj.service.imp;

import com.example.utj.entity.Permiso;
import com.example.utj.entity.PermisoRequest;
import com.example.utj.entity.PermisosResponse;
import com.example.utj.repository.PermisoRepository;
import com.example.utj.service.PermisosServices;
import com.example.utj.utils.DateFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class PermisosServicesImpl implements PermisosServices {
    @Autowired
    private PermisoRepository permisoRepository;
    PermisosResponse mockPermisos = new PermisosResponse();

    DateFormatter dateFormatter = new DateFormatter();


    public List<Permiso> getAllPermisos(){

       return permisoRepository.findAll();

    }

    public List<Permiso> getUsrPermisos(Integer usrId){
        log.info("Buscando permisos del usuario : " + usrId);
        return permisoRepository.findAllByUsuarioIdusuario(usrId);
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

    public String savePermiso(PermisoRequest newPermiso) throws ParseException {
        Permiso formattedPermiso = new Permiso();

        formattedPermiso.setFechainicio(dateFormatter.getDate(newPermiso.getFechainicio()));
        formattedPermiso.setFechafin(dateFormatter.getDate(newPermiso.getFechafin()));
        formattedPermiso.setFechasolicitud(dateFormatter.getDate(newPermiso.getFechasolicitud()));
        formattedPermiso.setNombre(newPermiso.getNombre());
        formattedPermiso.setUsuarioIdusuario(newPermiso.getUsuarioIdusuario());
        formattedPermiso.setEstado("1");
        formattedPermiso.setTipo(newPermiso.getTipo());
        formattedPermiso.setRolIdrol(newPermiso.getRolIdRol());

        permisoRepository.save(formattedPermiso);

        return "permiso creado exitosamente!";
    }

    public String modificarPermiso(Integer idPermiso, String accion) {
        switch (accion){
            case "aprobar":{
                permisoRepository.updateEstado(idPermiso, "2");
                return "Permiso aprobado exitodamente";
            }
            case "rechazar":{
                permisoRepository.updateEstado(idPermiso, "3");
                return "Permiso rechazado exitodamente";
            }
            case "cancelar":{
                permisoRepository.updateEstado(idPermiso, "4");
                return "Permiso cancelado exitodamente";
            }
            default:{
                return "Opcion no establecida";
            }

        }
    }

}
