package br.com.ibmec.projetocloud.ikaros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ibmec.projetocloud.ikaros.model.Postagem;
import br.com.ibmec.projetocloud.ikaros.repository.PostagemRepository;

public class PostagemService {
    @Autowired
    private PostagemRepository _postagemRepository;

    public List<Postagem> findAll() {
        return this._postagemRepository.findAll();
    }

    public Optional<Postagem> findById(Long id) {
        return this._postagemRepository.findById(id);
    }
}
