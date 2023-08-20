package br.com.projetoikaros.projetoikaros.model;

import java.time.Clock;
import java.time.LocalDateTime;

public class Notificacoes {
    private Integer id;
    private String tipo;
    private Boolean visualizado = false;
    private LocalDateTime dataHora;
    private Usuario usuarioOrigem;
    private Usuario usuarioDestino;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean getVisualizado() {
        return visualizado;
    }

    public boolean setVisualizado(boolean visualizado) {
        return this.visualizado = visualizado;
    }

    public LocalDateTime dataHora() {
        return dataHora();
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public LocalDateTime setdataHora() {
        return now(Clock.systemDefaultZone());
    }

    private LocalDateTime now(Clock clock) {
        return LocalDateTime.now(clock);
    }

    public Usuario getUsuarioOrigem() {
        return usuarioOrigem;
    }

    public void setUsuarioOrigem(Usuario usuarioOrigem) {
        this.usuarioOrigem = usuarioOrigem;
    }

    public Usuario getUsuarioDestino() {
        return usuarioDestino;
    }

    public void setUsuarioDestino(Usuario usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }
}
