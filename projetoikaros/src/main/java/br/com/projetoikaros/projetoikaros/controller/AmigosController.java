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

import br.com.projetoikaros.projetoikaros.model.Amigos;

@RestController
@RequestMapping("/amigos")
public class AmigosController {
    @GetMapping
    public ResponseEntity<List<Amigos>> getAll() {
        try {
            List<Amigos> items = new ArrayList<Amigos>();
            Amigos amigo = new Amigos();
            // amigo.setAmizadeId(1);
            // amigo.setRelacionamentoAmizade1(usuario1.getId());
            // amigo.setRelacionamentoAmizade2(usuario2.getId());

            items.add(amigo);
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}