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
@Tag (name = "Postagem", description = "API DE POSTAGEM IKAROS")
public class PostagemController {

    @Autowired
    private PostagemService _postagemService;

    @Autowired
    private UsuarioService _usuarioService;

    @GetMapping
    @Operation(summary = "Buscando postagens de um usuário pelo ID do usuário", method = "GET")
    public ResponseEntity<List<Postagem>> getAll(@PathVariable("idUsuario") long idUsuario) {
        try {
            return new ResponseEntity<>(this._postagemService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{idPosatagem}")
    @Operation(summary = "Buscando todas as postagens de um usuário através do ID da postagem", method = "GET")
    public ResponseEntity<Postagem> getById(@PathVariable("id") Long id) {

        Optional<Postagem> result = this._postagemService.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Operation(summary = "Adicionando postagem de um usuário", method = "POST")
    public ResponseEntity<Postagem> create(@PathVariable("idUsuario") long idUsuario, @RequestBody Postagem postagem) {
        try {

            Optional<Usuario> usuario = _usuarioService.getById(idUsuario);

            if (usuario.isPresent() == false)
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

            usuario.get().addPostagem(postagem);
            this._usuarioService.save(usuario.get());

            return new ResponseEntity<>(postagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{idPosatagem}")
    @Operation(summary = "Atualizando informações de uma postagem pelo ID", method = "PUT")
    public ResponseEntity<Postagem> update(@PathVariable("id") Long id, @RequestBody Postagem PostagemNovosDados) {

        Optional<Postagem> result = this._postagemService.findById(id);

        if (result.isPresent() == false) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Postagem PostagemASerAtualizado = result.get();
        PostagemASerAtualizado.setConteudoPost(PostagemNovosDados.getConteudoPost());
        PostagemASerAtualizado.setImagem(PostagemNovosDados.getImagem());
        PostagemASerAtualizado.setCurtidas(PostagemASerAtualizado.getCurtidas());

        this._postagemService.saveOrUpdate(PostagemASerAtualizado);

        return new ResponseEntity<>(PostagemASerAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("{idPosatagem}")
    @Operation(summary = "Deletando uma postagem pelo ID", method = "DELETE")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {

            Optional<Postagem> postagemASerExcluida = this._postagemService.findById(id);

            if (postagemASerExcluida.isPresent() == false) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            this._postagemService.delete(postagemASerExcluida.get().getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
