package br.com.ibmec.projetocloud.ikaros.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ibmec.projetocloud.ikaros.model.Amigos;

public interface AmigosRepository extends JpaRepository<Amigos, Long>{
    Optional<Amigos> findById(Long Id);
}
