package br.com.projetoikaros.projetoikaros.controller;

import java.util.ArrayList;
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

import br.com.projetoikaros.projetoikaros.model.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        try {
            List<Usuario> items = new ArrayList<Usuario>();
            Usuario usuario1 = new Usuario();
            usuario1.setId(1);
            usuario1.setNome("Igor");
            usuario1.setSobrenome("Mariano");
            usuario1.setData_aniversario(1965,1,25);
            usuario1.setEmail("test@email.com");
            usuario1.setSenha("123456789");

            items.add(usuario1);
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}