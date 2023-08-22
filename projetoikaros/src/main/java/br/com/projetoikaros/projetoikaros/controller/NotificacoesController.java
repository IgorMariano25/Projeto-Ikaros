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
            Notificacoes result = this._notificacoesRepository.save(item);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Notificacoes> update(@PathVariable("id") Long id, @RequestBody Notificacoes notificacoesNovosDados) {

        Optional<Notificacoes> result = this._notificacoesRepository.findById(id);

        if (result.isPresent() == false ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Notificacoes notificacaoASerAtualizada = result.get();
        notificacaoASerAtualizada.setTipo(notificacoesNovosDados.getTipo());
        notificacaoASerAtualizada.setUsuarioDestino(notificacoesNovosDados.getUsuarioDestino());
        notificacaoASerAtualizada.setUsuarioOrigem(notificacoesNovosDados.getUsuarioOrigem());
        notificacaoASerAtualizada.setVisualizado(notificacoesNovosDados.getVisualizado());
        notificacaoASerAtualizada.setDataHora(notificacoesNovosDados.getDataHora());

        this._notificacoesRepository.save(notificacaoASerAtualizada);
        return new ResponseEntity<>(notificacaoASerAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {

            Optional<Notificacoes> notificacaoASerExcluida = this._notificacoesRepository.findById(id);

            // Não achei a pessoa a ser excluida
            if (notificacaoASerExcluida.isPresent() == false) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

           this._notificacoesRepository.delete(notificacaoASerExcluida.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
