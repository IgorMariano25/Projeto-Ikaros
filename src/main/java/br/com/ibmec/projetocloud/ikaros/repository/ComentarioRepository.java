package br.com.ibmec.projetocloud.ikaros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ibmec.projetocloud.ikaros.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
    
}
