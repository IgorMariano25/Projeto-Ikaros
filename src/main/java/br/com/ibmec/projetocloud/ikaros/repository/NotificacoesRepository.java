package br.com.ibmec.projetocloud.ikaros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ibmec.projetocloud.ikaros.model.Notificacoes;

public interface NotificacoesRepository extends JpaRepository<Notificacoes, Long>{
    
}