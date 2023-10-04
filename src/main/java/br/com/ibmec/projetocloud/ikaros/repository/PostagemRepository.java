package br.com.ibmec.projetocloud.ikaros.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ibmec.projetocloud.ikaros.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    Optional<Postagem> findById(Long Id);
}
