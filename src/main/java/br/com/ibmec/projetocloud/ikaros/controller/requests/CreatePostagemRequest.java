package br.com.ibmec.projetocloud.ikaros.controller.requests;

import java.time.LocalDateTime;
public class CreatePostagemRequest {

    private Long postagemId;
    private String conteudoPost;
    private String imagem;
    private Integer curtidas;
    private LocalDateTime dataHoraPublicacao;

    public Long getPostagemId() {
        return this.postagemId;
    }

    public void setPostagemId(Long postagemId) {
        this.postagemId = postagemId;
    }

    public String getConteudoPost() {
        return this.conteudoPost;
    }

    public void setConteudoPost(String conteudoPost) {
        this.conteudoPost = conteudoPost;
    }

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getCurtidas() {
        return this.curtidas;
    }

    public void setCurtidas(Integer curtidas) {
        this.curtidas = curtidas;
    }

    public LocalDateTime getDataHoraPublicacao() {
        return this.dataHoraPublicacao;
    }

    public void setDataHoraPublicacao(LocalDateTime dataHoraPublicacao) {
        this.dataHoraPublicacao = dataHoraPublicacao;
    }
}
