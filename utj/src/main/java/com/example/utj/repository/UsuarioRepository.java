package com.example.utj.repository;

import com.example.utj.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Usuario findByNombreAndContrasena(String nombre, String contrasena);

}
