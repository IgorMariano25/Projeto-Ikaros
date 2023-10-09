package br.com.ibmec.projetocloud.ikaros.controller.responses;

import java.time.LocalDateTime;

public class CreateComentarioResponse {

    private Long comentarioId;
    private String conteudo;
    private LocalDateTime dataPublicacaoComentario;

    public CreateComentarioResponse(Long comentarioId, String conteudo, LocalDateTime dataPublicacaoComentario) {
        this.comentarioId = comentarioId;
        this.conteudo = conteudo;
        this.dataPublicacaoComentario = dataPublicacaoComentario;
    }

    public CreateComentarioResponse(Long comentarioId, String conteudo) {
        this.comentarioId = comentarioId;
        this.conteudo = conteudo;
    }

    public Long getId() {
        return this.comentarioId;
    }

    public void setId(Long comentarioId) {
        this.comentarioId = comentarioId;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataPublicacaoComentario() {
        return this.dataPublicacaoComentario;
    }

    public void setDataPublicacaoComentario(LocalDateTime dataPublicacaoComentario) {
        this.dataPublicacaoComentario = dataPublicacaoComentario;
    }

}