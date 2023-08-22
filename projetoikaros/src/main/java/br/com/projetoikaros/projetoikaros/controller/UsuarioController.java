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

import br.com.projetoikaros.projetoikaros.model.Usuario;
import br.com.projetoikaros.projetoikaros.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository _usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        try {
            return new ResponseEntity<>(this._usuarioRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Long id) {

        Optional<Usuario> result = this._usuarioRepository.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario item) {
        try {
            Usuario result = this._usuarioRepository.save(item);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") Long id, @RequestBody Usuario usuarioNovosDados) {
        
        Optional<Usuario> result = this._usuarioRepository.findById(id);


       

        if (result.isPresent() == false ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Usuario usuarioASerAtualizado = result.get();
        usuarioASerAtualizado.setNome(usuarioNovosDados.getNome());
        usuarioASerAtualizado.setSobrenome(usuarioNovosDados.getSobrenome());

        this._usuarioRepository.save(usuarioASerAtualizado);

        return new ResponseEntity<>(usuarioASerAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {

            Optional<Usuario> usuarioASerExcluido = this._usuarioRepository.findById(id);


            // Não achei a pessoa a ser excluida
            if (usuarioASerExcluido.isPresent() == false) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

           this._usuarioRepository.delete(usuarioASerExcluido.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
