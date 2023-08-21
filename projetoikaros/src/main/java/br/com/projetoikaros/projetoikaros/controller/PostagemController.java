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

    @GetMapping
    public ResponseEntity<List<Postagem>> getAll() {
        try {
            List<Postagem> items = new ArrayList<Postagem>();
            Postagem postagem1 = new Postagem();
            // postagem1.setId(1);
            postagem1.setUsuarioPublicador(null);
            postagem1.setConteudoPost("Texto do post 1");
            postagem1.setImagem("Url/aaaaaaaa");
            postagem1.setCurtidas(112);
            postagem1.setHoraPublicacao();

            items.add(postagem1);
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
