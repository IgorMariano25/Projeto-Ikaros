package br.com.projetoikaros.projetoikaros.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "ID_usuarioQueComento", nullable = false)
    private Usuario usuarioQueComento;

    @Column(name = "Data_de_Publicacao", nullable = false)
    private LocalDate data_publicacao_comentario;

    @Column(name = "conteudo_comentario", length = 100, nullable = false)
    private String conteudo;

    @Column(name = "ID_Post", nullable = false)
    private Postagem postId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData_publicacao_comentario() {
        return data_publicacao_comentario;
    }

    public void setData_publicacao_comentario(int ano, int mes, int dia) {
        this.data_publicacao_comentario = data_publicacao_comentario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Usuario getUsuarioQueComento() {
        return usuarioQueComento;
    }

    public void setUsuarioQueComento(Usuario usuarioQueComento) {
        this.usuarioQueComento = usuarioQueComento;
    }

    public Postagem getPostId() {
        return postId;
    }

    public void setPostId(Postagem postId) {
        this.postId = postId;
    }
}
