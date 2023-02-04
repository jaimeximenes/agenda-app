package com.agenda.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.app.Model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
    TipoUsuario findByNomeLike(String nome);

    TipoUsuario findByidTipoUsuarioAndNome(int id, String nome);

    TipoUsuario findByNome(String nome);

}
