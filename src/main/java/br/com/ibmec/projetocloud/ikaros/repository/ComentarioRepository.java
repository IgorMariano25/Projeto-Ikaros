package br.com.ibmec.projetocloud.ikaros.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ibmec.projetocloud.ikaros.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
    Optional<Comentario> findById(Long Id);
}
