package br.com.ibmec.projetocloud.ikaros.controller.responses;

public class CreateAmigosResponse {

    private Long amizadeId;

    public CreateAmigosResponse(Long amizadeId) {
        this.amizadeId = amizadeId;
    }

    public Long getAmizadeId() {
        return this.amizadeId;
    }

    public void setAmizadeId(Long amizadeId) {
        this.amizadeId = amizadeId;
    }
}
