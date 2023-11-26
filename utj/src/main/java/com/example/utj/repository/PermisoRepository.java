package com.example.utj.repository;

import com.example.utj.entity.Permiso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PermisoRepository extends CrudRepository<Permiso, Integer> {

    @Query(value="SELECT p.`idPermiso`,\n" +
            "p.diaSolicitado,\n" +
            "st.nombreEstado estado,\n" +
            "p.fechaSolicitud,\n" +
            "p.iddocumento,\n" +
            "usr.nombre,\n" +
            "tp.nombre tipo\n" +
            "FROM `permiso`  p\n" +
            "left JOIN usuario usr on p.`usuario_idUsuario` = usr.idUsuario\n" +
            "left JOIN tipo_permiso tp on p.tipo = tp.idTipoPermiso\n" +
            "left join estado st on p.estado = st.idEstado", nativeQuery= true )
    List<Permiso> findAll();
}
