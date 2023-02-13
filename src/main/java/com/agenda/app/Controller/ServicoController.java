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

import com.agenda.app.Model.Servico;
import com.agenda.app.repository.ServicoRepository;

@RestController
@RequestMapping(value = "/servico")
public class ServicoController {
    @PostMapping
    public ResponseEntity<Object> criarNovoServico(@RequestBody Servico servico) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(servicoRepository.save(servico));

        } catch (DataIntegrityViolationException d) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro ao tentar criar um servico");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao tentar criar um servico");
        }
    }

    @GetMapping
    public List<Servico> obterServicos() {
        return servicoRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Servico> obterServicoById(@PathVariable("id") int id) {
        return servicoRepository.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteServicoById(@PathVariable("id") int id) {
        servicoRepository.deleteById(id);
        return "Servico deletado com sucesso";
    }

    @PutMapping
    public ResponseEntity<Servico> atualizaServicoById(@RequestBody Servico servico) {
        return ResponseEntity.status(HttpStatus.OK).body(servicoRepository.save(servico));
    }

    @GetMapping(value = "/prestador/{id}")
    public ResponseEntity<List<Servico>> obterServicosDoPrestador(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicoRepository.findByPrestador(id));
    }

    @Autowired
    private ServicoRepository servicoRepository;
}