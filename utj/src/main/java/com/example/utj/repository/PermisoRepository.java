package com.example.utj.repository;

import com.example.utj.entity.Permiso;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PermisoRepository extends CrudRepository<Permiso, Integer> {

    @Query(value="SELECT p.`idPermiso`, p.`rol_idRol`, p.fechasolicitud, p.fechainicio, p.fechafin, st.nombreEstado estado, p.iddocumento, usr.nombre, tp.nombre tipo, p.iddocumento, p.usuario_idUsuario FROM `permiso` p left JOIN usuario usr on p.`usuario_idUsuario` = usr.idUsuario left JOIN tipo_permiso tp on p.tipo = tp.idTipoPermiso left join estado st on p.estado = st.idEstado;", nativeQuery= true )
    List<Permiso> findAll();

    List<Permiso> findAllByUsuarioIdusuario(Integer usuarioIdusuario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE utjmovil.permiso SET estado = :estado WHERE idPermiso = :idPermiso", nativeQuery = true)
    int updateEstado(@Param("idPermiso") Integer idPermiso, @Param("estado") String estado);



}
