package br.com.projetoikaros.projetoikaros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projetoikaros.projetoikaros.model.Usuario;
import br.com.projetoikaros.projetoikaros.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository _usuarioRepository;

    public List<Usuario> findAll() {
        return this._usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) throws Exception {
        if (this._usuarioRepository.countById(usuario.getId()) > 0) {
            throw new Exception("Este ID já existe na base de dados");
        }
        this._usuarioRepository.save(usuario);
        return usuario;
    }
}
