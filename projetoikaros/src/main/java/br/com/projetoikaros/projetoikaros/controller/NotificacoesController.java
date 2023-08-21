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

import br.com.projetoikaros.projetoikaros.model.Notificacoes;


@RestController
@RequestMapping("/notificacoes")
public class NotificacoesController {
    
    @GetMapping
    public ResponseEntity<List<Notificacoes>> getAll() {
        try {
            List<Notificacoes> items = new ArrayList<Notificacoes>();
            Notificacoes notificacao1 = new Notificacoes();
            // notificacao1.setId(1);
            notificacao1.setTipo("Comentário");
            notificacao1.setVisualizado(false);
            notificacao1.setDataHora(null);
            notificacao1.setUsuarioOrigem(null);
            notificacao1.setUsuarioDestino(null);
            

            items.add(notificacao1);
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
