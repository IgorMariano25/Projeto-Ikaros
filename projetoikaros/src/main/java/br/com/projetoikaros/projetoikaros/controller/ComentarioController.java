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

import br.com.projetoikaros.projetoikaros.model.Comentario;
import br.com.projetoikaros.projetoikaros.model.Postagem;
import br.com.projetoikaros.projetoikaros.model.Usuario;

@RestController
@RequestMapping("/comentario")
class ComentarioController {

    private static ArrayList<Comentario> Comentarios = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Comentario>> getAll() {
        try {
            return new ResponseEntity<>(Comentarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Comentario> getById(@PathVariable("id") Integer id) {

        Comentario result = null;

        for (Comentario item : Comentarios) {
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
        public ResponseEntity<Comentario> create(@RequestBody Comentario item) {
        try {

        //Usuario usuario = Usuario.buscarUsuarioPorId(item.getUsuarioQueComento().getId());
        //Postagem postagem = Postagem.buscarPostagemPorId(item.getPostId().getId());
        
        // Definindo as instâncias válidas nos campos do Comentario
        //item.setUsuarioQueComento(usuario);
        //item.setPostId(postagem);

        Comentarios.add(item);
            return new ResponseEntity<>(item, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Comentario> update(@PathVariable("id") Integer id, @RequestBody Comentario comentarioNovosDados) {
        
        Comentario comentarioASerAtualizado = null;

        for (Comentario item : Comentarios) {
            if (item.getId() == id) {
                comentarioASerAtualizado = item;
                break;
            }
        }

        if (comentarioASerAtualizado == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        comentarioASerAtualizado.setConteudo(comentarioNovosDados.getConteudo());
        
        return new ResponseEntity<>(comentarioASerAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {

            Comentario comentarioASerExcluido = null;

            for (Comentario item : Comentarios) {
                if (item.getId() == id) {
                    comentarioASerExcluido = item;
                    break;
                }
            }

            // Não achei a pessoa a ser excluida
            if (comentarioASerExcluido == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Comentarios.remove(comentarioASerExcluido);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    


}