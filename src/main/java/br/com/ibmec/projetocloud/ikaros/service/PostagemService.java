package br.com.ibmec.projetocloud.ikaros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibmec.projetocloud.ikaros.model.Postagem;
import br.com.ibmec.projetocloud.ikaros.repository.PostagemRepository;

@Service
public class PostagemService {
    @Autowired
    private PostagemRepository postagemRepository;

    public Postagem create(Postagem postagem) {
        return this.postagemRepository.save(postagem);
    }

    public Optional<Postagem> getById(long id) {
        return this.postagemRepository.findById(id);
    }

    public List<Postagem> findAll() {
        return this.postagemRepository.findAll();
    }

    public List<Postagem> findAllByUsuario(Long idUser){
        return this.postagemRepository.findAllByUsuarioId(idUser);
    }

    public void saveOrUpdate(Postagem postagem) {
        this.postagemRepository.save(postagem);
    }

    public Optional<Postagem> findById(Long id) {
        return this.postagemRepository.findById(id);
    }

    public Postagem update(long id, Postagem newData) throws Exception {
        Optional<Postagem> opPostagem = this.postagemRepository.findById(id);

        if (opPostagem.isEmpty()) {
            throw new Exception("Não encontrei a postagem a ser atualizada");
        }

        Postagem postagem = opPostagem.get();
        postagem.setConteudoPost(newData.getConteudoPost());
        postagem.setImagem(newData.getImagem());
        postagem.setCurtidas(newData.getCurtidas());

        this.postagemRepository.save(postagem);

        return postagem;
    }

    public void delete(long id) throws Exception {
        Optional<Postagem> opPostagem = this.postagemRepository.findById(id);

        if (opPostagem.isEmpty()) {
            throw new Exception("Não encontrei a postagem a ser atualizada");
        }

        this.postagemRepository.delete(opPostagem.get());
    }

    public Postagem save(Postagem postagem) {
        return postagemRepository.save(postagem);
    }
}
