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

    @GetMapping("{id}")
    public ResponseEntity<Postagem> getById(@PathVariable("id") Integer id) {

        Postagem result = null;

        for (Postagem item : Postagens) {
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
    public ResponseEntity<Postagem> create(@RequestBody Postagem item) {
        try {
            Postagens.add(item);
            return new ResponseEntity<>(item, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Postagem> update(@PathVariable("id") Integer id, @RequestBody Postagem PostagemNovosDados) {
        
        Postagem PostagemASerAtualizado = null;

        for (Postagem item : Postagens) {
            if (item.getId() == id) {
                PostagemASerAtualizado = item;
                break;
            }
        }

        if (PostagemASerAtualizado == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PostagemASerAtualizado.setConteudoPost(PostagemNovosDados.getConteudoPost());
        PostagemASerAtualizado.setImagem(PostagemNovosDados.getImagem());

        return new ResponseEntity<>(PostagemASerAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {

            Postagem PostagemASerExcluido = null;

            for (Postagem item : Postagens) {
                if (item.getId() == id) {
                    PostagemASerExcluido = item;
                    break;
                }
            }

            // Não achei a pessoa a ser excluida
            if (PostagemASerExcluido == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Postagens.remove(PostagemASerExcluido);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
