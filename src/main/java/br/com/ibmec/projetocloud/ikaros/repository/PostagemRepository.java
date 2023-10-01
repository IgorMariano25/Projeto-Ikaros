package br.com.ibmec.projetocloud.ikaros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ibmec.projetocloud.ikaros.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{
   
}
