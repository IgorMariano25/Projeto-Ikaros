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
    private UsuarioRepository _usuarioRepository;

    public Usuario create(Usuario usuario) {
        return this._usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return this._usuarioRepository.findAll();
    }

    public Optional<Usuario> getById(Long id) {
        return this._usuarioRepository.findById(id);
    }

    public void saveOrUpdate(Usuario usuario) {
        this._usuarioRepository.save(usuario);
    }

    public void savePostagem(Usuario usuario) {
        this._usuarioRepository.save(usuario);
    }

    public Usuario save(Usuario usuario) throws Exception {
        if (this._usuarioRepository.countById(usuario.getId()) > 0) {
            throw new Exception("Este ID já existe na base de dados");
        }
        this._usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario update(long id, Usuario newData) throws Exception {
        Optional<Usuario> opUsuario = this._usuarioRepository.findById(id);

        if (opUsuario.isPresent() == false) {
            throw new Exception("Não encontrei o usuario a ser atualizado");
        }

        Usuario usuario = opUsuario.get();
        usuario.setEmail(newData.getEmail());
        usuario.setSenha(newData.getSenha());

        this._usuarioRepository.save(usuario);

        return usuario;
    }

    public void delete(long id) throws Exception {
        Optional<Usuario> opUsuario = this._usuarioRepository.findById(id);

        if (opUsuario.isPresent() == false) {
            throw new Exception("Não encontrei o usuario a ser deletado");
        }

        this._usuarioRepository.delete(opUsuario.get());
    }
}
