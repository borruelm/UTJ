package com.example.utj.controller;

import com.example.utj.entity.LoginRequest;
import com.example.utj.entity.UserResponse;
import com.example.utj.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/user")
public class User {
    @Autowired
    UserServices usrServices;

    @PostMapping(value = "/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest usrReq){
        return new ResponseEntity<>(usrServices.loginUsr(usrReq), HttpStatus.ACCEPTED);
    }

}
