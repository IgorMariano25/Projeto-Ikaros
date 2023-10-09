package br.com.ibmec.projetocloud.ikaros.model;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Postagem")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postagemId;

    @Column(name = "conteudoPost", nullable = false, length = 100)
    private String conteudoPost;

    @Column(name = "urlImagem", nullable = false)
    private String imagem;

    @Column(name = "curtidas", nullable = false)
    private Integer curtidas = 0;

    @Column(name = "dataDaPublicacao", nullable = false)
    private LocalDateTime dataHoraPublicacao;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "comentarioId")
    private List<Comentario> comentarios;

    @JsonIgnore
    @Column(name = "usuario_id")
    private Long usuarioId;

    public Long getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return postagemId;
    }

    public void setId(Long postagemId) {
        this.postagemId = postagemId;
    }

    public String getConteudoPost() {
        return conteudoPost;
    }

    public void setConteudoPost(String conteudoPost) {
        this.conteudoPost = conteudoPost;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(Integer curtidas) {
        this.curtidas = curtidas;
    }

    public LocalDateTime getDataHoraPublicacao() {
        return dataHoraPublicacao;
    }

    public void setDataHoraPublicacao(LocalDateTime dataHoraPublicacao) {
        this.dataHoraPublicacao = dataHoraPublicacao;
    }

    public LocalDateTime setHoraPublicacao() {
        return now(Clock.systemDefaultZone());
    }

    private LocalDateTime now(Clock clock) {
        return LocalDateTime.now(clock);
    }

    public List<Comentario> getComentarios() {
        return this.comentarios;
    }

    public void addComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

}
