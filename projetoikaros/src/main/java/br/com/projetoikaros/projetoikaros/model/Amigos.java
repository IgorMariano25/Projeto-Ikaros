package br.com.projetoikaros.projetoikaros.model;

public class Amigos {
    private Integer amizadeId;
    private Usuario relacionamentoAmizade1;
    private Usuario relacionamentoAmizade2;

    public Integer getAmizadeId() {
        return this.amizadeId;
    }

    public void setAmizadeId(Integer amizadeId) {
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