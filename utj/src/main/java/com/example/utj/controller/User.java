package com.example.utj.controller;

import com.example.utj.entity.LoginRequest;
import com.example.utj.entity.UserResponse;
import com.example.utj.entity.Usuario;
import com.example.utj.repository.UsuarioRepository;
import com.example.utj.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/user")
public class User {
    @Autowired
    private UserServices usrServices;

    @PostMapping(value = "/login")
    public ResponseEntity<UserResponse> login(LoginRequest usrReq){
        return new ResponseEntity<>(usrServices.loginUsr(usrReq), HttpStatus.ACCEPTED);
    }

    @PostMapping(value="/crear")
    public ResponseEntity<String> crear(Usuario newUsr){

        return new ResponseEntity<>(usrServices.crear(newUsr), HttpStatus.ACCEPTED);

    }

    @GetMapping(value = "/all")
     public ResponseEntity<List<Usuario>> allUsr(){
        return new ResponseEntity<>(usrServices.getAll(), HttpStatus.ACCEPTED);
    }

}
