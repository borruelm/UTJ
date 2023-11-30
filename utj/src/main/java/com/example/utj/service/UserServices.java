package com.example.utj.service;

import com.example.utj.entity.LoginRequest;
import com.example.utj.entity.UserResponse;
import com.example.utj.entity.Usuario;

import java.util.List;

public interface UserServices {

    UserResponse loginUsr(LoginRequest inputUsr);

    String crear(Usuario newUsr);

    List<Usuario> getAll();
}
