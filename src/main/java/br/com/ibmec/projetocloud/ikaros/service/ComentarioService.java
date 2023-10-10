package br.com.ibmec.projetocloud.ikaros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibmec.projetocloud.ikaros.controller.requests.CreateComentarioRequest;
import br.com.ibmec.projetocloud.ikaros.model.Comentario;
import br.com.ibmec.projetocloud.ikaros.model.Postagem;
import br.com.ibmec.projetocloud.ikaros.repository.ComentarioRepository;
import br.com.ibmec.projetocloud.ikaros.service.ComentarioService;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PostagemService postagemService;

    public List<Comentario> findAll() {
        return this.comentarioRepository.findAll();
    }

    public Optional<Comentario> findById(Long id) {
        return this.comentarioRepository.findById(id);
    }

    public Comentario create(Comentario comentario) {
        return this.comentarioRepository.save(comentario);
    }

    public Comentario save(Long idPostagem, CreateComentarioRequest comentarioRequest) throws Exception {
        Optional<Postagem> opPostagem = this.postagemService.getById(idPostagem);

        if (!opPostagem.isPresent()) {
            throw new Exception("Postagem não encontrada no banco de dados");
        }

        Postagem postagem = opPostagem.get();

        Comentario comentario = new Comentario();
        comentario.setConteudo(comentarioRequest.getConteudo());

        postagem.addComentario(comentario);
        this.comentarioRepository.save(comentario);

        return comentario;
    }

    public void saveOrUpdate(Comentario comentario) {
        this.comentarioRepository.save(comentario);
    }

    public Comentario save(Comentario comentario) {
        return this.comentarioRepository.save(comentario);
    }

    public Comentario update(long id, Comentario newData) throws Exception {
        Optional<Comentario> opComentario = this.comentarioRepository.findById(id);

        if (opComentario.isEmpty()) {
            throw new Exception("Não encontrei o comentario a ser atualizado");
        }

        Comentario comentario = opComentario.get();
        comentario.setConteudo(newData.getConteudo());

        this.comentarioRepository.save(comentario);

        return comentario;
    }

    public void delete(long id) throws Exception {
        Optional<Comentario> opComentario = this.comentarioRepository.findById(id);

        if (opComentario.isEmpty()) {
            throw new Exception("Não encontrei o comentario a ser deletado");
        }

        this.comentarioRepository.delete(opComentario.get());
    }
}