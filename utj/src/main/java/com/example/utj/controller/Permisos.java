package com.example.utj.controller;

import com.example.utj.entity.Permiso;
import com.example.utj.entity.PermisoRequest;
import com.example.utj.entity.PermisosResponse;
import com.example.utj.service.PermisosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v2/permiso")
public class Permisos {

    @Autowired
    private PermisosServices permisosServices;

    @GetMapping("/all")
    public ResponseEntity<List<Permiso>> getAllPermisos(){
        return new ResponseEntity<>(permisosServices.getAllPermisos(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/user/{usrId}")
    public ResponseEntity<List<Permiso>> getPermisosByUsr( @PathVariable(value="usrId", required = true) Integer usrId ){

        return new ResponseEntity<>(permisosServices.getUsrPermisos(usrId), HttpStatus.ACCEPTED);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> saveNewPermiso(PermisoRequest newPermiso) throws ParseException {
        return new ResponseEntity<>(permisosServices.savePermiso(newPermiso), HttpStatus.ACCEPTED);
    }

    @PostMapping("/modificar")
    public ResponseEntity<String> updatePermiso(Integer idPermiso, String accion){
        return new ResponseEntity<>( permisosServices.modificarPermiso(idPermiso, accion), HttpStatus.ACCEPTED);

    }

}
