package br.com.ibmec.projetocloud.ikaros.controller;

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

import br.com.ibmec.projetocloud.ikaros.model.Notificacoes;
import br.com.ibmec.projetocloud.ikaros.service.NotificacoesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/notificacoes")
@Tag(name = "Notificações", description = "Resquições para a tabela Notificações")
public class NotificacoesController {

    @Autowired
    private NotificacoesService notificacoesService;

    @GetMapping
    @Operation(summary = "Buscando todas as notificações de um usuário", method = "GET")
    public ResponseEntity<List<Notificacoes>> getAll() {
        try {
            return new ResponseEntity<>(this.notificacoesService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{idNotificacao}")
    @Operation(summary = "Buscando notificação pelo id", method = "GET")
    public ResponseEntity<Notificacoes> getById(@PathVariable("idNotificacao") Long idNotificacao) {

        Optional<Notificacoes> result = this.notificacoesService.getById(idNotificacao);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Operation(summary = "Adicionando uma notificação", method = "POST")
    public ResponseEntity<Notificacoes> create(@RequestBody Notificacoes item) {
        try {
            Notificacoes result = this.notificacoesService.create(item);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{idNotificacao}")
    @Operation(summary = "Atualizando informações de uma notificação", method = "PUT")
    public ResponseEntity<Notificacoes> update(
            @PathVariable("idNotificacao") Long idNotificacao,
            @RequestBody Notificacoes notificacoesNovosDados) {

        Optional<Notificacoes> result = this.notificacoesService.getById(idNotificacao);

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Notificacoes notificacaoASerAtualizada = result.get();
        notificacaoASerAtualizada.setTipo(notificacoesNovosDados.getTipo());
        notificacaoASerAtualizada.setUsuarioDestino(notificacoesNovosDados.getUsuarioDestino());
        notificacaoASerAtualizada.setUsuarioOrigem(notificacoesNovosDados.getUsuarioOrigem());
        notificacaoASerAtualizada.setVisualizado(notificacoesNovosDados.getVisualizado());

        this.notificacoesService.saveOrUpdate(notificacoesNovosDados);
        return new ResponseEntity<>(notificacaoASerAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("{idNotificacao}")
    @Operation(summary = "Deletando uma notificação", method = "DELETE")
    public ResponseEntity<HttpStatus> delete(@PathVariable("idNotificacao") Long idNotificacao) {
        try {

            Optional<Notificacoes> notificacaoASerExcluida = this.notificacoesService.getById(idNotificacao);

            // Não achei a pessoa a ser excluida
            if (notificacaoASerExcluida.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            notificacoesService.delete(idNotificacao);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
