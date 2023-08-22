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

import br.com.projetoikaros.projetoikaros.model.Postagem;
import br.com.projetoikaros.projetoikaros.model.Usuario;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

    private static ArrayList<Postagem> Postagens = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Postagem>> getAll() {
        try {
            return new ResponseEntity<>(Postagens, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Postagem> create(@RequestBody Postagem item) {
        try {
            Usuario usuario = Usuario.buscarUsuarioPorId(item.getId());
            item.setId(usuario.getId());
            Postagens.add(item);
            return new ResponseEntity<>(item, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
