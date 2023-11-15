package com.example.utj.service;

import com.example.utj.entity.LoginRequest;
import com.example.utj.entity.UserResponse;

public interface UserServices {

    UserResponse loginUsr(LoginRequest inputUsr);
}
