package br.com.projetoikaros.projetoikaros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.projetoikaros.projetoikaros.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
    
}
