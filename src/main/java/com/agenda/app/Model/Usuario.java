package com.agenda.app.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;
    @Column(name = "sobrenome", nullable = false, length = 45)
    private String sobrenome;
    @Column(name = "email", unique = true, nullable = false, length = 45)
    private String email;
    @Column(name = "senha", nullable = false, length = 45)
    private String senha;

    @OneToOne
    @JoinColumn(name = "idTipoUsuario")
    private TipoUsuario tipoUsuario;

}
