package br.com.projetoikaros.projetoikaros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.projetoikaros.projetoikaros.model.Postagem;
import br.com.projetoikaros.projetoikaros.model.Usuario;
import br.com.projetoikaros.projetoikaros.repository.PostagemRepository;
import br.com.projetoikaros.projetoikaros.repository.UsuarioRepository;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

    @Autowired
    private PostagemRepository _postagemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Postagem>> getAll() {
        try {
            return new ResponseEntity<>(this._postagemRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Postagem> getById(@PathVariable("id") Long id) {

        Optional<Postagem> result = this._postagemRepository.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("{idUsuario}")
    public ResponseEntity<Postagem> create(@PathVariable("idUsuario") long idUsuario, @RequestBody Postagem postagem) {
        try {

            Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);

            if (usuario.isPresent() == false)
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

            usuario.get().addPostagem(postagem);
            this.usuarioRepository.save(usuario.get());

            return new ResponseEntity<>(postagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Postagem> update(@PathVariable("id") Long id, @RequestBody Postagem PostagemNovosDados) {

        Optional<Postagem> result = this._postagemRepository.findById(id);

        if (result.isPresent() == false) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Postagem PostagemASerAtualizado = result.get();
        PostagemASerAtualizado.setConteudoPost(PostagemNovosDados.getConteudoPost());
        PostagemASerAtualizado.setImagem(PostagemNovosDados.getImagem());
        PostagemASerAtualizado.setCurtidas(PostagemASerAtualizado.getCurtidas());

        this._postagemRepository.save(PostagemASerAtualizado);

        return new ResponseEntity<>(PostagemASerAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {

            Optional<Postagem> postagemASerExcluida = this._postagemRepository.findById(id);

            if (postagemASerExcluida.isPresent() == false) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            this._postagemRepository.delete(postagemASerExcluida.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
