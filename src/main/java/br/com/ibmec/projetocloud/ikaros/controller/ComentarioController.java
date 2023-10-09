package br.com.ibmec.projetocloud.ikaros.controller;

import java.time.LocalDateTime;
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
import br.com.ibmec.projetocloud.ikaros.controller.requests.CreateComentarioRequest;
import br.com.ibmec.projetocloud.ikaros.controller.responses.CreateComentarioResponse;
import br.com.ibmec.projetocloud.ikaros.model.Comentario;
import br.com.ibmec.projetocloud.ikaros.model.Postagem;
import br.com.ibmec.projetocloud.ikaros.service.ComentarioService;
import br.com.ibmec.projetocloud.ikaros.service.PostagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/postagem")
@Tag(name = "Comentário", description = "Resquições para a tabela Comentário")
class ComentarioController {

    @Autowired
    private ComentarioService _comentarioService;
    @Autowired
    private PostagemService _postagemService;

    @GetMapping
    @Operation(summary = "Buscando comentários de uma postagem", method = "GET")
    public ResponseEntity<List<Comentario>> getAll() {
        try {
            return new ResponseEntity<>(this._comentarioService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idPostagem}/comentario/{idComentario}")
    @Operation(summary = "Buscando comentários de uma postagem ID do comentário", method = "GET")
    public ResponseEntity<Comentario> getById(@PathVariable("idComentario") Long id) {

        Optional<Comentario> result = this._comentarioService.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{idPostagem}/comentario")
    @Operation(summary = "Adiciona um comentário a uma postagem", method = "POST")
    public ResponseEntity<CreateComentarioResponse> create(
            @PathVariable("idPostagem") Long idPostagem,
            @RequestBody CreateComentarioRequest createComentarioRequest) {
        try {
            Optional<Postagem> opPostagem = _postagemService.getById(idPostagem);
            if (opPostagem.isPresent() == false) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Comentario comentario = new Comentario();
            comentario.setComentador(createComentarioRequest.getComentador());
            comentario.setConteudo(createComentarioRequest.getConteudo());
            comentario.setPostagem(createComentarioRequest.getPostagem());
            comentario.setDataPublicacaoComentario(createComentarioRequest.getDataPublicacaoComentario());

            opPostagem.get().addComentario(comentario);

            _postagemService.save(opPostagem.get());

            CreateComentarioResponse response = new CreateComentarioResponse(comentario.getComentarioId(),
                    comentario.getConteudo());

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{idPostagem}/comentario")@Operation(summary="Adiciona um comentário a uma postagem",method="POST"){

    public ResponseEntity<CreateComentarioResponse> update()
        try {
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletando o comentário de uma postagem", method = "DELETE")

    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {

            Optional<Comentario> comentarioASerExcluido = this._comentarioService.findById(id);
            if (comentarioASerExcluido.isPresent() == false) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            this._comentarioService.delete(comentarioASerExcluido.get().getComentarioId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}