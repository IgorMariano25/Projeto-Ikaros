package br.com.projetoikaros.projetoikaros.model;

import java.time.LocalDate;

public class Comentario {
    private Integer id;
    private LocalDate data_publicacao_comentario;
    private String conteudo;
    private Usuario usuarioQueComento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData_publicacao_comentario() {
        return data_publicacao_comentario;
    }

    public void setData_publicacao_comentario(LocalDate data_publicacao_comentario) {
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
}
