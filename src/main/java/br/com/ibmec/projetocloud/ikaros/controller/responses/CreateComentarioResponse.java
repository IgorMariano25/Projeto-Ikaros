package br.com.ibmec.projetocloud.ikaros.controller.responses;

public class CreateComentarioResponse {

    private Long comentarioId;
    private String conteudo;

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

    public CreateComentarioResponse(Long comentarioId, String conteudo) {
        this.comentarioId = comentarioId;
        this.conteudo = conteudo;
    }
}