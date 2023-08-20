package br.com.projetoikaros.projetoikaros.model;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Postagem {
    private Integer id;
    private String usuarioPublicador;
    private String conteudoPost;
    private String imagem;
    private Integer curtidas;
    private LocalDate dataPublicacao;
    private LocalDate horaPublicacao;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUsuario() {
        return usuarioPublicador;
    }

    public void setUsuario(String usuarioPublicador) {
        this.usuarioPublicador = usuarioPublicador;
    }

    public String getPost() {
        return this.conteudoPost;
    }

    public void setPost(String conteudoPost) {
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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(int ano, int mes, int dia) {
        this.dataPublicacao = LocalDate.of(ano, mes, dia);
    }

    public LocalDate getHoraPublicacao() {
        return horaPublicacao;
    }

    public LocalDateTime setHoraPublicacao() {
        return now(Clock.systemDefaultZone());
    }

    private LocalDateTime now(Clock clock) {
        return LocalDateTime.now(clock);
    }
    
    }


