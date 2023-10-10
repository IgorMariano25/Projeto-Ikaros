package br.com.ibmec.projetocloud.ikaros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibmec.projetocloud.ikaros.model.Notificacoes;
import br.com.ibmec.projetocloud.ikaros.repository.NotificacoesRepository;

@Service
public class NotificacoesService {
    @Autowired
    private NotificacoesRepository notificacoesRepository;

    public Notificacoes create( Notificacoes notificacoes) {
        return this.notificacoesRepository.save(notificacoes);
    }

    public Optional<Notificacoes> getById(long id) {
        return this.notificacoesRepository.findById(id);
    }
    
    public List<Notificacoes> findAll() {
        return this.notificacoesRepository.findAll();
    }

    public void saveOrUpdate(Notificacoes notificacoes) {
        this.notificacoesRepository.save(notificacoes);
    }

    public Notificacoes update(long id, Notificacoes newData) throws Exception {
        Optional<Notificacoes> opNotificacoes = this.notificacoesRepository.findById(id);

        if (opNotificacoes.isEmpty()) {
            throw new Exception("Não encontrei a notificacao a ser atualizada");
        }

        Notificacoes notificacoes = opNotificacoes.get();
        notificacoes.setTipo(newData.getTipo());
        notificacoes.setUsuarioOrigem(newData.getUsuarioOrigem());
        notificacoes.setUsuarioDestino(newData.getUsuarioDestino());
        notificacoes.setVisualizado(newData.getVisualizado());

        this.notificacoesRepository.save(notificacoes);

        return notificacoes;
    }

    public void delete(long id) throws Exception {
        Optional<Notificacoes> opNotificacoes = this.notificacoesRepository.findById(id);

        if (opNotificacoes.isEmpty()) {
            throw new Exception("Não encontrei a notificacao a ser deletada");
        }

        this.notificacoesRepository.delete(opNotificacoes.get());
    }

}
