package br.com.ibmec.projetocloud.ikaros.controller.responses;

public class CreateComentarioResponse {

    private Long idComentario;
    private String conteudo;

    public Long getId() {
        return this.idComentario;
    }

    public void setId(Long idComentario) {
        this.idComentario = idComentario;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public CreateComentarioResponse(Long idComentario, String conteudo) {
        this.idComentario = idComentario;
        this.conteudo = conteudo;
    }
}