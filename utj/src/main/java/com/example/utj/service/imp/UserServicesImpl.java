package com.example.utj.service.imp;

import com.example.utj.entity.LoginRequest;
import com.example.utj.entity.UserResponse;
import com.example.utj.service.UserServices;
import org.springframework.stereotype.Service;


@Service
public class UserServicesImpl implements UserServices {
    public UserResponse loginUsr(LoginRequest inputUsr){
        UserResponse usrOutput = new UserResponse();
        usrOutput.setUsrName(inputUsr.getUsrName());
        usrOutput.setRole("Admin");
        usrOutput.setDaysAvailable(10);
        usrOutput.setAdmin(true);
        return usrOutput;

    }
}
