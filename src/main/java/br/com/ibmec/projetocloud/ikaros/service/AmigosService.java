package br.com.ibmec.projetocloud.ikaros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ibmec.projetocloud.ikaros.model.Amigos;
import br.com.ibmec.projetocloud.ikaros.repository.AmigosRepository;

public class AmigosService {

    @Autowired
    private AmigosRepository _amigosRepository;
    public List<Amigos> findAll() {
        return this._amigosRepository.findAll();
    }

    public Optional<Amigos> findById(Long id) {
        return this._amigosRepository.findById(id);
    }
}
