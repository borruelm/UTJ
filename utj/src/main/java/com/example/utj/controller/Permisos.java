package com.example.utj.controller;

import com.example.utj.entity.PermisosResponse;
import com.example.utj.service.PermisosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/permiso")
public class Permisos {

    @Autowired
    private PermisosServices permisosServices;
    @GetMapping("/all")
    public ResponseEntity<List<PermisosResponse>> getAllPermisos(){
        return new ResponseEntity<>(permisosServices.getAllPermisos(), HttpStatus.ACCEPTED);
    }
}
