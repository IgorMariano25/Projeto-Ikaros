package br.com.ibmec.projetocloud.ikaros.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ibmec.projetocloud.ikaros.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    Optional<Postagem> findById(Long usuarioId);
    List<Postagem> findAllByUsuarioId(Long usuarioId);
}
