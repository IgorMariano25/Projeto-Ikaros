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

import br.com.projetoikaros.projetoikaros.model.Notificacoes;
import br.com.projetoikaros.projetoikaros.model.Notificacoes;
import br.com.projetoikaros.projetoikaros.repository.NotificacacoesRepository;

@RestController
@RequestMapping("/notificacoes")
public class NotificacoesController {

    @Autowired
    private NotificacacoesRepository _notificacoesRepository;

    @GetMapping
    public ResponseEntity<List<Notificacoes>> getAll() {
        try {
            return new ResponseEntity<>(this._notificacoesRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Notificacoes> getById(@PathVariable("id") Long id) {

        Optional<Notificacoes> result = this._notificacoesRepository.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Notificacoes> create(@RequestBody Notificacoes item) {
        try {
            Notificacoes.add(item);
            return new ResponseEntity<>(item, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Notificacoes> update(@PathVariable("id") Integer id, @RequestBody Notificacoes NotificacoesNovosDados) {
        
        Notificacoes NotificacaoASerAtualizada = null;

        for (Notificacoes item : Notificacoes) {
            if (item.getId() == id) {
                NotificacaoASerAtualizada = item;
                break;
            }
        }

        if (NotificacaoASerAtualizada == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        NotificacaoASerAtualizada.setTipo(NotificacoesNovosDados.getTipo());
        NotificacaoASerAtualizada.setUsuarioDestino(NotificacoesNovosDados.getUsuarioDestino());
        NotificacaoASerAtualizada.setUsuarioOrigem(NotificacoesNovosDados.getUsuarioOrigem());
        NotificacaoASerAtualizada.setVisualizado(NotificacoesNovosDados.getVisualizado());
        NotificacaoASerAtualizada.setDataHora(NotificacoesNovosDados.getDataHora());

        return new ResponseEntity<>(NotificacaoASerAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {

            Notificacoes NotificacaoASerExcluida = null;

            for (Notificacoes item : Notificacoes) {
                if (item.getId() == id) {
                    NotificacaoASerExcluida = item;
                    break;
                }
            }

            // Não achei a pessoa a ser excluida
            if (NotificacaoASerExcluida == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Notificacoes.remove(NotificacaoASerExcluida);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
