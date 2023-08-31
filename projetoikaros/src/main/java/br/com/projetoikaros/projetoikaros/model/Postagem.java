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
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Postagem")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conteudoPost", nullable = false, length = 100)
    private String conteudoPost;

    @Column(name = "URL_Imagem", nullable = false)
    private String imagem;

    @Column(name = "curtidas", nullable = false)
    private Integer curtidas = 0;

    @Column(name = "Data_da_Publicacao", nullable = false)
    private LocalDateTime dataHoraPublicacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudoPost() {
        return conteudoPost;
    }

    public void setConteudoPost(String conteudoPost) {
        this.conteudoPost = conteudoPost;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(Integer curtidas) {
        this.curtidas = curtidas;
    }

    public LocalDateTime getDataHoraPublicacao() {
        return dataHoraPublicacao;
    }

    public void setDataHoraPublicacao(LocalDateTime dataHoraPublicacao) {
        this.dataHoraPublicacao = dataHoraPublicacao;
    }

    public LocalDateTime setHoraPublicacao() {
        return now(Clock.systemDefaultZone());
    }

    private LocalDateTime now(Clock clock) {
        return LocalDateTime.now(clock);
    }

    public static Postagem buscarPostagemPorId(Integer id) {
        if (id != null) {
            Postagem postagem = new Postagem();
            return postagem;
        } else {
            return null;
        }
    }
}
