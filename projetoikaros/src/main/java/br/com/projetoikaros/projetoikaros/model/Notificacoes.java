package br.com.projetoikaros.projetoikaros.model;

import java.time.Clock;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Notificacoes")
public class Notificacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "tipo_da_notificacao", nullable = false, length = 45)
    private String tipo;

    @Column(name = "notificacao_foi_visualizada", nullable = false)
    private Boolean visualizado = false;

    @Column(name = "data", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "ID_usuarioOrigem", referencedColumnName = "id", nullable = false)
    private Usuario usuarioOrigem;

    @ManyToOne
    @JoinColumn(name = "ID_usuarioDestino", referencedColumnName = "id", nullable = false)
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
