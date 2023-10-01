package br.com.ibmec.projetocloud.ikaros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ibmec.projetocloud.ikaros.model.Comentario;
import br.com.ibmec.projetocloud.ikaros.repository.ComentarioRepository;

public class ComentarioService {
    @Autowired
    private ComentarioRepository _comentarioRepository;

    public List<Comentario> findAll() {
        return this._comentarioRepository.findAll();
    }

    public Optional<Comentario> findById(Long id) {
        return this._comentarioRepository.findById(id);
    }
}
