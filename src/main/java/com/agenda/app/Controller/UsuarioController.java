package com.agenda.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.app.Model.Usuario;
import com.agenda.app.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    @PostMapping
    public Usuario criarNovoUsuario(@RequestBody Usuario novoUsuario) {
        return usuarioRepository.save(novoUsuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Usuario obterUsuarioById(@PathVariable("id") int id) {
        return usuarioRepository.findById(id);
    }

    @GetMapping(value = "/{nome}")
    public Usuario obterUsuarioByNome(@PathVariable("nome") String nome) {
        return usuarioRepository.findByNome(nome);
    }

    @GetMapping(value = "/tipo/{idTipoUsuario}")
    public List<Usuario> obterUsuarioPorTipo(@PathVariable("idTipoUsuario") int id) {
        return usuarioRepository.findByTipoUsuario(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUsuario(@PathVariable("id") int id) {
        usuarioRepository.deleteById(id);
    }

    @PutMapping
    public Usuario atualizaUsuarioById(@RequestBody Usuario usuario) {
        Usuario usuarioBd = usuarioRepository.findById(usuario.getIdUsuario());
        usuarioBd.setNome(usuario.getNome());
        return usuarioRepository.save(usuarioBd);
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

}
