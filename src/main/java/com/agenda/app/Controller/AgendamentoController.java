package com.agenda.app.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.app.Model.Agendamento;
import com.agenda.app.repository.AgendamentoRepository;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendamentoController {
    @PostMapping
    public ResponseEntity<Object> criarAgendamento(@RequestBody Agendamento agendamento) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(agendamentoRepository.save(agendamento));

        } catch (DataIntegrityViolationException d) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro ao tentar criar um agendamento");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao tentar criar um agendamento");
        }
    }

    @GetMapping
    public List<Agendamento> obterAgendamentos() {
        return agendamentoRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Agendamento> obterAgendamentoPorId(@PathVariable("id") int id) {
        return agendamentoRepository.findById(id);
    }
    @GetMapping(value = "agendamentoporprestador/{id}")
    public List<Agendamento> obterAgendamentosPorPrestador(@PathVariable("id") int id) {
        return agendamentoRepository.findByPrestador(id);
    }


    @GetMapping(value = "agendamentosporclientes/{id}")
    public List<Agendamento> obterAgendamentosPorClientes(@PathVariable("id") int id) {
        return agendamentoRepository.findByCliente(id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteAgendamentoPorId(@PathVariable("id") int id) {
        agendamentoRepository.deleteById(id);
        return "Servico deletado com sucesso";
    }

    @PutMapping
    public ResponseEntity<Agendamento> atualizaAgendamentoPorId(@RequestBody Agendamento agendamento) {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoRepository.save(agendamento));
    }

    @Autowired
    private AgendamentoRepository agendamentoRepository;

}
