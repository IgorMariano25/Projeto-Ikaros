package br.com.ibmec.projetocloud.ikaros.controller.responses;

import java.time.LocalDateTime;
import java.util.List;

import br.com.ibmec.projetocloud.ikaros.model.Comentario;

public class CreatePostagemResponse {

    private Long postagemId;
    private Long usuarioId;
    private String conteudoPost;
    private String imagem;
    private Integer curtidas;
    private LocalDateTime dataHoraPublicacao;
    private List<Comentario> comentarios;

    public CreatePostagemResponse(Long postagemId, Long usuarioId, String conteudoPost, String imagem, Integer curtidas,
            LocalDateTime dataHoraPublicacao, List<Comentario> comentarios) {
        this.postagemId = postagemId;
        this.usuarioId = usuarioId;
        this.conteudoPost = conteudoPost;
        this.imagem = imagem;
        this.curtidas = curtidas;
        this.dataHoraPublicacao = dataHoraPublicacao;
        this.comentarios = comentarios;
    }

    public Long getPostagemId() {
        return this.postagemId;
    }

    public void setPostagemId(Long postagemId) {
        this.postagemId = postagemId;
    }

    public Long getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
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

    public List<Comentario> getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
