package br.com.ibmec.projetocloud.ikaros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibmec.projetocloud.ikaros.model.Amigos;
import br.com.ibmec.projetocloud.ikaros.repository.AmigosRepository;

@Service
public class AmigosService {

    @Autowired
    private AmigosRepository amigosRepository;
    public List<Amigos> findAll() {
        return this.amigosRepository.findAll();
    }

    public Optional<Amigos> findById(Long id) {
        return this.amigosRepository.findById(id);
    }

    public Amigos create(Amigos amigos) {
        return this.amigosRepository.save(amigos);
    }

    public void saveOrUpdate(Amigos amigos) {
        this.amigosRepository.save(amigos);
    }

    public void delete(long id) throws Exception {
        Optional<Amigos> opPost = this.amigosRepository.findById(id);

        if (opPost.isEmpty()) {
            throw new Exception("Não encontrei o amigo a ser deletado");
        }

        this.amigosRepository.delete(opPost.get());
    }
}