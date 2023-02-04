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

import com.agenda.app.Model.TipoUsuario;
import com.agenda.app.repository.TipoUsuarioRepository;

@RestController
@RequestMapping(value="/tipousuarios")
public class TipoUsuarioController {

    @PostMapping
    public ResponseEntity<Object> criarNovoTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(tipoUsuarioRepository.save(tipoUsuario));

        } catch (DataIntegrityViolationException d) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro ao criar usuario");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro tentarao criar usuario");
        }

    }

    @GetMapping
    public List<TipoUsuario> obterTipoUsuarios() {
        return tipoUsuarioRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<TipoUsuario> obterTipoUsuariosById(@PathVariable("id") int id) {
        return tipoUsuarioRepository.findById(id);
    }
    @GetMapping(value = "/{nome}")
    public TipoUsuario obterTipoUsuariosByNome(@PathVariable("nome") String nome) {
        return tipoUsuarioRepository.findByNome(nome);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteTipoUsuariosById(@PathVariable("id") int id) {
        tipoUsuarioRepository.deleteById(id);
        return "Tipo do usuario deletado";
    }

    @PutMapping
    public TipoUsuario atualizaTipoUsuariosById(@RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario tipoUsuarioBd = tipoUsuarioRepository.findById(tipoUsuario.getIdTipoUsuario()).get();
        tipoUsuarioBd.setNome(tipoUsuario.getNome());

        return tipoUsuarioRepository.save(tipoUsuarioBd);

    }

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;
            
}
