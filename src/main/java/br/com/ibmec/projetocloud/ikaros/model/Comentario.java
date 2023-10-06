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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDusuarioQueComentou", referencedColumnName = "id", nullable = false)
    private Usuario comentador;

    @Column(name = "DatadePublicacao", nullable = false)
    private LocalDateTime dataPublicacaoComentario;

    @Column(name = "conteudoComentario", length = 100, nullable = false)
    private String conteudo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "IDPost", referencedColumnName = "id", nullable = false)
    private Postagem postagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_publicacao_comentario() {
        return dataPublicacaoComentario;
    }

    public void setData_publicacao_comentario(LocalDateTime dataPublicacaoComentario) {
        this.dataPublicacaoComentario = dataPublicacaoComentario;
    }

    public LocalDateTime setData_publicacao_comentario() {
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
