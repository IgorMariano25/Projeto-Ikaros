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

import br.com.ibmec.projetocloud.ikaros.model.Postagem;
import br.com.ibmec.projetocloud.ikaros.model.Usuario;
import br.com.ibmec.projetocloud.ikaros.service.PostagemService;
import br.com.ibmec.projetocloud.ikaros.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuario/{idUsuario}/postagem")
@Tag(name = "Postagem", description = "Resquições para a tabela Postagem")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Buscando postagens de um usuário pelo ID do usuário", method = "GET")
    public ResponseEntity<List<Postagem>> getAll(@PathVariable("idUsuario") Long idUsuario) {
        try {
            return new ResponseEntity<>(this.postagemService.findAllByUsuario(idUsuario), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{idPostagem}")
    @Operation(summary = "Buscando todas as postagens de um usuário através do ID da postagem", method = "GET")
    public ResponseEntity<Postagem> findById(@PathVariable("idPostagem") Long id) {

        Optional<Postagem> result = this.postagemService.findById(id);

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Adicionando postagem de um usuário", method = "POST")
    public ResponseEntity<Postagem> create(@PathVariable("idUsuario") Long idUsuario, @RequestBody Postagem postagem) {
        try {

            Optional<Usuario> usuario = usuarioService.getById(idUsuario);

            if (usuario.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            usuario.get().addPostagem(postagem);
            this.usuarioService.savePostagem(usuario.get());

            return new ResponseEntity<>(postagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{idPostagem}")
    @Operation(summary = "Atualizando informações de uma postagem pelo ID", method = "PUT")
    public ResponseEntity<Postagem> update(@PathVariable("idPostagem") Long id,
            @RequestBody Postagem postagemNovosDados) {

        Optional<Postagem> result = this.postagemService.findById(id);

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Postagem postagemASerAtualizado = result.get();
        postagemASerAtualizado.setConteudoPost(postagemNovosDados.getConteudoPost());
        postagemASerAtualizado.setImagem(postagemNovosDados.getImagem());
        postagemASerAtualizado.setCurtidas(postagemASerAtualizado.getCurtidas());

        this.postagemService.saveOrUpdate(postagemASerAtualizado);

        return new ResponseEntity<>(postagemASerAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("{idPosatagem}")
    @Operation(summary = "Deletando uma postagem pelo ID", method = "DELETE")
    public ResponseEntity<HttpStatus> delete(@PathVariable("idPosatagem") Long idPosatagem) {
        try {

            Optional<Postagem> postagemASerExcluida = this.postagemService.findById(idPosatagem);

            if (postagemASerExcluida.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            postagemService.delete(idPosatagem);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
