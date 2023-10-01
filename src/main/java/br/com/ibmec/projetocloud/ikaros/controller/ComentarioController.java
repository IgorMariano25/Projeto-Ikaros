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

import br.com.ibmec.projetocloud.ikaros.model.Comentario;
import br.com.ibmec.projetocloud.ikaros.service.ComentarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/postagem/{idPostagem}/comentario")
@Tag (name = "Comentário", description = "Resquições para a tabela Comentário")
class ComentarioController {

    @Autowired
    private ComentarioService _comentarioService;

    @GetMapping
    @Operation(summary = "Buscando comentários de uma postagem", method = "GET")
    public ResponseEntity<List<Comentario>> getAll() {
        try {
            return new ResponseEntity<>(this._comentarioService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{idComentario}")
    @Operation(summary = "Buscando comentários de uma postagem ID do comentário", method = "GET")
    public ResponseEntity<Comentario> getById(@PathVariable("id") Long id) {

        Optional<Comentario> result = this._comentarioService.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

     @PostMapping
     @Operation(summary = "Adiciona um comentário a postagem", method = "POST")
        public ResponseEntity<Comentario> create(@RequestBody Comentario comentario) {
        try {
            Comentario result = this._comentarioService.create(comentario);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualizano informações de um comentário", method = "PUT")
    public ResponseEntity<Comentario> update(@PathVariable("id") Long id, @RequestBody Comentario comentarioNovosDados) {

        Optional<Comentario> result = this._comentarioService.findById(id);
        if (result.isPresent() == false ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Comentario comentarioASerAtualizado = result.get();
        comentarioASerAtualizado.setConteudo(comentarioNovosDados.getConteudo());
        comentarioASerAtualizado.setData_publicacao_comentario(comentarioNovosDados.getData_publicacao_comentario());

        return new ResponseEntity<>(comentarioASerAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletando o comentário de uma postagem", method = "DELETE")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {

            Optional<Comentario> comentarioASerExcluido = this._comentarioService.findById(id);
            if (comentarioASerExcluido.isPresent() == false) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            this._comentarioService.delete(comentarioASerExcluido.get().getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}