package br.com.projetoikaros.projetoikaros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoikaros.projetoikaros.model.Amigos;
import br.com.projetoikaros.projetoikaros.repository.AmigosRepository;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/amigos")
@Tag (name = "amigos")
public class AmigosController {

    @Autowired
    private AmigosRepository _amigosRepository;

    @GetMapping
    public ResponseEntity<List<Amigos>> getAll() {
        try {
            return new ResponseEntity<>(this._amigosRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Amigos> getById(@PathVariable("id") Long id) {

        Optional<Amigos> result = this._amigosRepository.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Amigos> create(@RequestBody Amigos item) {
        try {
            Amigos result = this._amigosRepository.save(item);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Amigos> update(@PathVariable("id") Long id, @RequestBody Amigos amigosNovosDados) {
        
        Optional<Amigos> result = this._amigosRepository.findById(id);

        if (result.isPresent() == false ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Amigos amigosASerAtualizado = result.get();
        amigosASerAtualizado.setRelacionamentoAmizade1(amigosNovosDados.getRelacionamentoAmizade1());
        amigosASerAtualizado.setRelacionamentoAmizade2(amigosNovosDados.getRelacionamentoAmizade2());

        this._amigosRepository.save(amigosASerAtualizado);

        return new ResponseEntity<>(amigosASerAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {

            Optional<Amigos> amigosASerExcluido = this._amigosRepository.findById(id);

            // Não achei a pessoa a ser excluida
            if (amigosASerExcluido.isPresent() == false) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

           this._amigosRepository.delete(amigosASerExcluido.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}