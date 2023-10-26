package br.com.ibmec.projetocloud.ikaros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ibmec.projetocloud.ikaros.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Long countByUsuarioId(Long usuarioId);
    Long findByUsuarioId(Long usuarioId);
}