package br.com.ibmec.projetocloud.ikaros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ibmec.projetocloud.ikaros.model.Amigos;

public interface AmigosRepository extends JpaRepository<Amigos, Long>{
    
}
