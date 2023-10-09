package br.com.ibmec.projetocloud.ikaros.controller.requests;

import java.time.LocalDateTime;

import br.com.ibmec.projetocloud.ikaros.model.Usuario;

public class CreateNotificacoesRequest {

    private Long notificacoesId;
    private Boolean visualizado;
    private LocalDateTime dataHora;
    private Usuario usuarioOrigem;
    private Usuario usuarioDestino;

    public Long getNotificacoesId() {
        return this.notificacoesId;
    }

    public void setNotificacoesId(Long notificacoesId) {
        this.notificacoesId = notificacoesId;
    }

    public Boolean isVisualizado() {
        return this.visualizado;
    }

    public Boolean getVisualizado() {
        return this.visualizado;
    }

    public void setVisualizado(Boolean visualizado) {
        this.visualizado = visualizado;
    }

    public LocalDateTime getDataHora() {
        return this.dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getUsuarioOrigem() {
        return this.usuarioOrigem;
    }

    public void setUsuarioOrigem(Usuario usuarioOrigem) {
        this.usuarioOrigem = usuarioOrigem;
    }

    public Usuario getUsuarioDestino() {
        return this.usuarioDestino;
    }

    public void setUsuarioDestino(Usuario usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }
}
