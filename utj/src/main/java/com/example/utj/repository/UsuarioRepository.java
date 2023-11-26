package com.example.utj.repository;

import com.example.utj.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Usuario findByNombreAndContrasena(String nombre, String contrasena);

}
