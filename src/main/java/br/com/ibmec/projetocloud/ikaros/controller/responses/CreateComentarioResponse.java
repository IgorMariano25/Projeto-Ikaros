package br.com.ibmec.projetocloud.ikaros.controller.responses;

public class CreateComentarioResponse {

    private Long id; 
    private String conteudo; 

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public CreateComentarioResponse(Long id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }
}