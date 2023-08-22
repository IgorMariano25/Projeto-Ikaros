package br.com.projetoikaros.projetoikaros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.projetoikaros.projetoikaros.model.Amigos;

public interface AmigosRepository extends JpaRepository<Amigos, Long>{
    
}
