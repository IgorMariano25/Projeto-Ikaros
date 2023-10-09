package br.com.ibmec.projetocloud.ikaros.controller.requests;

import br.com.ibmec.projetocloud.ikaros.model.Usuario;

public class CreateAmigosRequest {

    private Long amizadeId;
    private Usuario relacionamentoAmizade1;
    private Usuario relacionamentoAmizade2;

    public Long getAmizadeId() {
        return this.amizadeId;
    }

    public void setAmizadeId(Long amizadeId) {
        this.amizadeId = amizadeId;
    }

    public Usuario getRelacionamentoAmizade1() {
        return this.relacionamentoAmizade1;
    }

    public void setRelacionamentoAmizade1(Usuario relacionamentoAmizade1) {
        this.relacionamentoAmizade1 = relacionamentoAmizade1;
    }

    public Usuario getRelacionamentoAmizade2() {
        return this.relacionamentoAmizade2;
    }

    public void setRelacionamentoAmizade2(Usuario relacionamentoAmizade2) {
        this.relacionamentoAmizade2 = relacionamentoAmizade2;
    }
}
