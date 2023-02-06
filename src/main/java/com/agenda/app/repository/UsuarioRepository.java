package com.agenda.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agenda.app.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByNome(String nome);

    Usuario findById(int id);

    @Query("SELECT u FROM tb_usuario u WHERE u.tipoUsuario.idTipoUsuario = :idTipoUsuario")
    List<Usuario> findByTipoUsuario(@Param("idTipoUsuario") int idTipoUsuario);

}