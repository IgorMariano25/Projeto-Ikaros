package br.com.projetoikaros.projetoikaros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.projetoikaros.projetoikaros.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{
   
}
