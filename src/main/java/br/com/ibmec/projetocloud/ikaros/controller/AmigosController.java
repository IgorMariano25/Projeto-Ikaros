package br.com.ibmec.projetocloud.ikaros.controller;

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

import br.com.ibmec.projetocloud.ikaros.model.Amigos;
import br.com.ibmec.projetocloud.ikaros.service.AmigosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/amigos")
@Tag (name = "Amigos", description = "Resquições para a tabela Amigos")
public class AmigosController {

    @Autowired
    private AmigosService amigosService;

    @GetMapping
    @Operation(summary = "Buscando todos os amigos de um usuário", method = "GET")
    public ResponseEntity<List<Amigos>> getAll() {
        try {
            return new ResponseEntity<>(this.amigosService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{idUsuario}")
    @Operation(summary = "Buscando amigos de um usuário pelo id", method = "GET")
    public ResponseEntity<Amigos> getById(@PathVariable("idUsuario") Long idUsuario) {

        Optional<Amigos> result = this.amigosService.findById(idUsuario);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Operation(summary = "Adicionando amigos", method = "POST")
    public ResponseEntity<Amigos> create(@RequestBody Amigos item) {
        try {
            Amigos result = this.amigosService.create(item);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{idAmizade}")
    @Operation(summary = "Atualizando amigos", method = "PUT")
    public ResponseEntity<Amigos> update(@PathVariable("idAmizade") Long idAmizade, @RequestBody Amigos amigosNovosDados) {
        
        Optional<Amigos> result = this.amigosService.findById(idAmizade);

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Amigos amigosASerAtualizado = result.get();
        amigosASerAtualizado.setRelacionamentoAmizade1(amigosNovosDados.getRelacionamentoAmizade1());
        amigosASerAtualizado.setRelacionamentoAmizade2(amigosNovosDados.getRelacionamentoAmizade2());

        this.amigosService.saveOrUpdate(amigosASerAtualizado);

        return new ResponseEntity<>(amigosASerAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("{idAmizade}")
    @Operation(summary = "Deletanto amizade/Deletando Id da amizade", method = "DELETE")
    public ResponseEntity<HttpStatus> delete(@PathVariable("idAmizade") Long idAmizade) {
        try {

            Optional<Amigos> amizadeASerExcluida = this.amigosService.findById(idAmizade);

            if (amizadeASerExcluida.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

           amigosService.delete(idAmizade);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}