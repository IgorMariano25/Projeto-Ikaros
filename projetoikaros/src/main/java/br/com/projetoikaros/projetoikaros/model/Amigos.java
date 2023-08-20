package br.com.projetoikaros.projetoikaros.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Amigos")
public class Amigos {

    @Id
    @Column(name = "ID_Amizade", nullable = false)
    private Integer amizadeId;

    @Id
    @Column(name = "ID_Amigo1", nullable = false)
    private Usuario relacionamentoAmizade1;

    @Id
    @Column(name = "ID_Amigo2", nullable = false)
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
