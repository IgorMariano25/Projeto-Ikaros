package br.com.ibmec.projetocloud.ikaros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ibmec.projetocloud.ikaros.model.Postagem;
import br.com.ibmec.projetocloud.ikaros.repository.PostagemRepository;
import jakarta.ws.rs.POST;

public class PostagemService {
    @Autowired
    private PostagemRepository _postagemRepository;

    public Postagem create(Postagem postagem) {
        return this._postagemRepository.save(postagem);
    }

    public Optional<Postagem> getById(long id) {
        return this._postagemRepository.findById(id);
    }
    
    public List<Postagem> findAll() {
        return this._postagemRepository.findAll();
    }

    public void saveOrUpdate(Postagem postagem) {
        this._postagemRepository.save(postagem);
    }

    public Optional<Postagem> findById(Long id) {
        return this._postagemRepository.findById(id);
    }


    public Postagem update(long id, Postagem newData) throws Exception {
        Optional<Postagem> opPostagem = this._postagemRepository.findById(id);

        if (opPostagem.isPresent() == false) {
            throw new Exception("Não encontrei a postagem a ser atualizada");
        }

        Postagem postagem = opPostagem.get();
        postagem.setConteudoPost(newData.getConteudoPost());
        postagem.setImagem(newData.getImagem());
        postagem.setCurtidas(newData.getCurtidas());

        this._postagemRepository.save(postagem);

        return postagem;
    }

    public void delete(long id) throws Exception {
        Optional<Postagem> opPostagem = this._postagemRepository.findById(id);

        if (opPostagem.isPresent() == false) {
            throw new Exception("Não encontrei a postagem a ser atualizada");
        }

        this._postagemRepository.delete(opPostagem.get());
    }
}
