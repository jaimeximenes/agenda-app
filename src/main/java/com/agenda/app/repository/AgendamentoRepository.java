package com.agenda.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agenda.app.Model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    // @Query("SELECT a FROM tb_agendamento a WHERE a.usuario.id_cliente =
    // :idCliente")
    @Query("SELECT a FROM tb_agendamento a where a.cliente.idUsuario = :idCliente")
    List<Agendamento> findByCliente(@Param("idCliente") int id);

    @Query("SELECT a FROM tb_agendamento a where a.servico.prestador.idUsuario = :idPrestador")
    List<Agendamento> findByPrestador(@Param("idPrestador") int id);

}
