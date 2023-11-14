package br.com.ibmec.projetocloud.ikaros.model;

import java.time.Clock;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long comentarioId;

    @ManyToOne
    @JoinColumn(name = "idUsuarioQueComentou", referencedColumnName = "usuarioId", nullable = false)
    private Usuario comentador;

    @Column(name = "dataDePublicacao", nullable = false)
    private LocalDateTime dataPublicacaoComentario;

    @Column(name = "conteudoComentario", length = 100, nullable = false)
    private String conteudo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idPost", referencedColumnName = "postagemId", nullable = false)
    private Postagem postagem;

    public long getComentarioId() {
        return this.comentarioId;
    }

    public void setComentarioId(long comentarioId) {
        this.comentarioId = comentarioId;
    }

    public LocalDateTime getDataPublicacaoComentario() {
        return dataPublicacaoComentario;
    }

    public void setDataPublicacaoComentario(LocalDateTime dataPublicacaoComentario) {
        this.dataPublicacaoComentario = dataPublicacaoComentario;
    }

    public LocalDateTime setDataPublicacaoComentario() {
        return now(Clock.systemDefaultZone());
    }

    private LocalDateTime now(Clock clock) {
        return LocalDateTime.now(clock);
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Usuario getUsuarioQueComento() {
        return comentador;
    }

    public void setUsuarioQueComento(Usuario comentador) {
        this.comentador = comentador;
    }

    public Postagem getPostId() {
        return postagem;
    }

    public void setPostId(Postagem postagem) {
        this.postagem = postagem;
    }
}
