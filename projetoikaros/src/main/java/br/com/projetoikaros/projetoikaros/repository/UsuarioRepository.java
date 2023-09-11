package br.com.projetoikaros.projetoikaros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.projetoikaros.projetoikaros.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    long countById(Long Id);
}