package com.example.utj.service.imp;

import com.example.utj.entity.LoginRequest;
import com.example.utj.entity.UserResponse;
import com.example.utj.entity.Usuario;
import com.example.utj.repository.UsuarioRepository;
import com.example.utj.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public UserResponse loginUsr(LoginRequest inputUsr) {
        UserResponse usrOutput = new UserResponse();
        Usuario usuario = usuarioRepository.findByNombreAndContrasena(inputUsr.getUsrName(), inputUsr.getKeyPass());
        usrOutput.setUsrName(usuario.getNombre());
        usrOutput.setRole(String.valueOf(usuario.getRol()));
        usrOutput.setDaysAvailable(10);
        usrOutput.setAdmin(usuario.getRol() == 1);

        return usrOutput;
    }

    public String crear(Usuario newUsr){
        usuarioRepository.save(newUsr);

        return "Usuarion creado con exito";

    }

    public List<Usuario> getAll(){
        return (List<Usuario>) usuarioRepository.findAll();
    }
}
