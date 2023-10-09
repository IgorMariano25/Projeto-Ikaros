package br.com.ibmec.projetocloud.ikaros.controller.requests;

import java.time.LocalDateTime;

import br.com.ibmec.projetocloud.ikaros.model.Postagem;
import br.com.ibmec.projetocloud.ikaros.model.Usuario;

public class CreateComentarioRequest {

    private Long comentarioId;
    private Usuario comentador;
    private LocalDateTime dataPublicacaoComentario;
    private String conteudo;
    private Postagem postagem;

    public Long getId() {
        return this.comentarioId;
    }

    public void setId(Long comentarioId) {
        this.comentarioId = comentarioId;
    }

    public Usuario getComentador() {
        return this.comentador;
    }

    public Long getIdComentador() {
        return comentador.getId();
    }

    public LocalDateTime getDataPublicacaoComentario() {
        return this.dataPublicacaoComentario;
    }

    public void setDataPublicacaoComentario(LocalDateTime dataPublicacaoComentario) {
        this.dataPublicacaoComentario = dataPublicacaoComentario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Postagem getPostagem() {
        return this.postagem;
    }

    public Long getIdPostagem() {
        return postagem.getId();
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }
}