package br.com.projetoikaros.projetoikaros.controller;

import java.util.ArrayList;
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

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private static ArrayList<Usuario> Usuarios = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        try {
            return new ResponseEntity<>(Usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Integer id) {

        Usuario result = null;

        for (Usuario item : Usuarios) {
            if (item.getId() == id) {
                result = item;
                break;
            }
        }

        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario item) {
        try {
            Usuarios.add(item);
            return new ResponseEntity<>(item, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") Integer id, @RequestBody Usuario usuarioNovosDados) {
        
        Usuario usuarioASerAtualizado = null;

        for (Usuario item : Usuarios) {
            if (item.getId() == id) {
                usuarioASerAtualizado = item;
                break;
            }
        }

        if (usuarioASerAtualizado != null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
        usuarioASerAtualizado.setNome(usuarioNovosDados.getNome());
        usuarioASerAtualizado.setSobrenome(usuarioNovosDados.getSobrenome());

        return new ResponseEntity<>(usuarioASerAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {

            Usuario usuarioASerExcluido = null;

            for (Usuario item : Usuarios) {
                if (item.getId() == id) {
                    usuarioASerExcluido = item;
                    break;
                }
            }

            // Não achei a pessoa a ser excluida
            if (usuarioASerExcluido == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Usuarios.remove(usuarioASerExcluido);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
