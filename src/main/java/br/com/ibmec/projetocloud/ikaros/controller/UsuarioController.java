package br.com.ibmec.projetocloud.ikaros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibmec.projetocloud.ikaros.controller.requests.CreateUsuarioRequest;
import br.com.ibmec.projetocloud.ikaros.controller.responses.CreateUsuarioResponse;
import br.com.ibmec.projetocloud.ikaros.model.Usuario;
import br.com.ibmec.projetocloud.ikaros.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
@Tag(name = "Usuário", description = "Resquições para a tabela Usuário")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Buscando todos os usuários", method = "GET")
    public ResponseEntity<List<Usuario>> getAll() {
        try {
            return new ResponseEntity<>(this.usuarioService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{usuarioId}")
    @Operation(summary = "Buscando um usuário pelo ID", method = "GET")
    public ResponseEntity<Usuario> getById(@PathVariable("usuarioId") Long usuarioId) {

        Optional<Usuario> result = this.usuarioService.getById(usuarioId);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Operation(summary = "Criando um usuário", method = "POST")
    public ResponseEntity<CreateUsuarioResponse> create(@RequestBody CreateUsuarioRequest createUsuarioRequest) {
        try {
            Usuario usuario = new Usuario();
            usuario.setNome(createUsuarioRequest.getNome());
            usuario.setSobrenome(createUsuarioRequest.getSobrenome());
            usuario.setDataAniversario(createUsuarioRequest.getDataAniversario());
            usuario.setEmail(createUsuarioRequest.getEmail());
            usuario.setSenha(createUsuarioRequest.getSenha());

            usuarioService.save(usuario);

            CreateUsuarioResponse response = new CreateUsuarioResponse(usuario.getNome(), usuario.getSobrenome());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{usuarioId}")
    @Operation(summary = "Atualizando informações de um usuário", method = "PUT")
    public ResponseEntity<Usuario> update(@PathVariable("usuarioId") Long usuarioId, @RequestBody Usuario usuarioNovosDados) {

        try {
            return new ResponseEntity<>(usuarioService.update(usuarioId, usuarioNovosDados), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("{usuarioId}")
    @Operation(summary = "Deletando um usuário", method = "DELETE")
    public ResponseEntity<HttpStatus> delete(@PathVariable("usuarioId") Long usuarioId) {
        try {

            Optional<Usuario> usuarioASerExcluido = this.usuarioService.getById(usuarioId);

            // Não achei a pessoa a ser excluida
            if (usuarioASerExcluido.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            this.usuarioService.delete(usuarioId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
