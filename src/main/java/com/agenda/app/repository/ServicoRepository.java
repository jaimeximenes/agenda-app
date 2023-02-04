package com.agenda.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agenda.app.Model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    @Query("SELECT u FROM tb_usuario u WHERE u.TipoUsuario.idUsuario = :idUsuario")
    List<Servico> findByUsuario(@Param("idUsuario") int idTipoUsuario);

}
