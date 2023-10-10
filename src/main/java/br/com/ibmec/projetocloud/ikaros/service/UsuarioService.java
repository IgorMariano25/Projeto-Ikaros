package br.com.ibmec.projetocloud.ikaros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibmec.projetocloud.ikaros.model.Usuario;
import br.com.ibmec.projetocloud.ikaros.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario create(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    public Optional<Usuario> getById(Long id) {
        return this.usuarioRepository.findById(id);
    }

    public Long findUsuarioById(Long usuarioId){
        return this.usuarioRepository.findUsuarioById(usuarioId);
    }

    public void saveOrUpdate(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    public void savePostagem(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    public Usuario save(Usuario usuario) throws Exception {
        if (this.usuarioRepository.countById(usuario.getId()) > 0) {
            throw new Exception("Este ID já existe na base de dados");
        }
        this.usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario update(long id, Usuario newData) throws Exception {
        Optional<Usuario> opUsuario = this.usuarioRepository.findById(id);

        if (opUsuario.isEmpty()) {
            throw new Exception("Não encontrei o usuario a ser atualizado");
        }

        Usuario usuario = opUsuario.get();
        usuario.setEmail(newData.getEmail());
        usuario.setSenha(newData.getSenha());

        this.usuarioRepository.save(usuario);

        return usuario;
    }

    public void delete(long id) throws Exception {
        Optional<Usuario> opUsuario = this.usuarioRepository.findById(id);

        if (opUsuario.isEmpty()) {
            throw new Exception("Não encontrei o usuario a ser deletado");
        }

        this.usuarioRepository.delete(opUsuario.get());
    }
}
