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

    public List<Notificacoes> findAll() {
        return this._notificacoesRepository.findAll();
    }

    public Optional<Notificacoes> findById(Long id) {
        return this._notificacoesRepository.findById(id);
    }
}
