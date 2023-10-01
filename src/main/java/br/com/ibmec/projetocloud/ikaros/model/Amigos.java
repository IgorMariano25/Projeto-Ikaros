package br.com.ibmec.projetocloud.ikaros.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Amigos")
public class Amigos {

    @Id
    @Column(name = "ID_Amizade", nullable = false)
    private Long amizadeId;

    @ManyToOne
    @JoinColumn(name = "ID_Amigo1", referencedColumnName = "id", nullable = false)
    private Usuario relacionamentoAmizade1;

    @ManyToOne
    @JoinColumn(name = "ID_Amigo2", referencedColumnName = "id", nullable = false)
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
