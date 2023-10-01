package br.com.ibmec.projetocloud.ikaros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ibmec.projetocloud.ikaros.model.Notificacoes;
import br.com.ibmec.projetocloud.ikaros.repository.NotificacoesRepository;

public class NotificacoesService {
    @Autowired
    private NotificacoesRepository _notificacoesRepository;

    public Notificacoes create( Notificacoes notificacoes) {
        return this._notificacoesRepository.save(notificacoes);
    }

    public Optional<Notificacoes> getById(long id) {
        return this._notificacoesRepository.findById(id);
    }
    
    public List<Notificacoes> findAll() {
        return this._notificacoesRepository.findAll();
    }

    public void saveOrUpdate(Notificacoes notificacoes) {
        this._notificacoesRepository.save(notificacoes);
    }

    public Notificacoes update(long id, Notificacoes newData) throws Exception {
        Optional<Notificacoes> opNotificacoes = this._notificacoesRepository.findById(id);

        if (opNotificacoes.isPresent() == false) {
            throw new Exception("Não encontrei a notificacao a ser atualizada");
        }

        Notificacoes notificacoes = opNotificacoes.get();
        notificacoes.setTipo(newData.getTipo());
        notificacoes.setUsuarioOrigem(newData.getUsuarioOrigem());
        notificacoes.setUsuarioDestino(newData.getUsuarioDestino());
        notificacoes.setVisualizado(newData.getVisualizado());

        this._notificacoesRepository.save(notificacoes);

        return notificacoes;
    }

    public void delete(long id) throws Exception {
        Optional<Notificacoes> opNotificacoes = this._notificacoesRepository.findById(id);

        if (opNotificacoes.isPresent() == false) {
            throw new Exception("Não encontrei a notificacao a ser deletada");
        }

        this._notificacoesRepository.delete(opNotificacoes.get());
    }

}
