package com.agenda.app.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "tb_servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServiço;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "descricao", nullable = false, length = 200)
    private String descricao;

    @OneToOne
    @JoinColumn(name="idPrestador")
    private Usuario prestador;
}
