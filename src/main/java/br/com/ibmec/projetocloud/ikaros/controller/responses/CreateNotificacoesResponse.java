package br.com.ibmec.projetocloud.ikaros.controller.responses;

import java.time.LocalDateTime;

import br.com.ibmec.projetocloud.ikaros.model.Usuario;

public class CreateNotificacoesResponse {

    private Boolean visualizado;
    private LocalDateTime dataHora;
    private Usuario usuarioOrigem;
    private Usuario usuarioDestino;

    public CreateNotificacoesResponse(Boolean visualizado, LocalDateTime dataHora, Usuario usuarioOrigem,
            Usuario usuarioDestino) {
        this.visualizado = visualizado;
        this.dataHora = dataHora;
        this.usuarioOrigem = usuarioOrigem;
        this.usuarioDestino = usuarioDestino;
    }
}
