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
import br.com.projetoikaros.projetoikaros.model.Usuario;

@RestController
@RequestMapping("/comentario")
class resourceNameController {

    @GetMapping
    public ResponseEntity<List<Comentario>> getAll() {
        try {
            List<Comentario> items = new ArrayList<Comentario>();
            Comentario comentario1 = new Comentario();
            comentario1.setId(1);
            comentario1.setConteudo("Muit legal !");
            comentario1.setPostId(postagem1.getId());
            comentario1.setUsuarioQueComento(usuario1.getNome());
            comentario1.setData_publicacao_comentario(1965,1,25);

            items.add(comentario1);
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}