package br.com.ibmec.projetocloud.ikaros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibmec.projetocloud.ikaros.model.Comentario;
import br.com.ibmec.projetocloud.ikaros.repository.ComentarioRepository;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository _comentarioRepository;

    public List<Comentario> findAll() {
        return this._comentarioRepository.findAll();
    }

    public Optional<Comentario> findById(Long id) {
        return this._comentarioRepository.findById(id);
    }

    public Comentario create(Comentario comentario) {
        return this._comentarioRepository.save(comentario);
    }

    public void saveOrUpdate(Comentario comentario) {
        this._comentarioRepository.save(comentario);
    }

    public Comentario update(long id, Comentario newData) throws Exception {
        Optional<Comentario> opComentario = this._comentarioRepository.findById(id);

        if (opComentario.isPresent() == false) {
            throw new Exception("Não encontrei o comentario a ser atualizado");
        }

        Comentario comentario = opComentario.get();
        comentario.setConteudo(newData.getConteudo());

        this._comentarioRepository.save(comentario);

        return comentario;
    }

    public void delete(long id) throws Exception {
        Optional<Comentario> opComentario = this._comentarioRepository.findById(id);

        if (opComentario.isPresent() == false) {
            throw new Exception("Não encontrei o comentario a ser deletado");
        }

        this._comentarioRepository.delete(opComentario.get());
    }
}