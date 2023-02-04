package com.agenda.app.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "tb_agendamento")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgendamento;
    @Column(name = "data")
    private LocalDate data;
    @Column(name = "hora")
    private LocalTime hora;

    @OneToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name="idServico")
    private Servico servico;
}
