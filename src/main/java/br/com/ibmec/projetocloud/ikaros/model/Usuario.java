package br.com.ibmec.projetocloud.ikaros.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long usuarioId;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "sobrenome", nullable = false, length = 100)
    private String sobrenome;

    @Column(name = "dataAniversairo", nullable = false)
    private LocalDate dataAniversario;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "senha", nullable = false, length = 45)
    private String senha;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private List<Postagem> postagens;

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }

    public void addPostagem(Postagem postagem) {
        this.postagens.add(postagem);
    }

    public Long getId() {
        return usuarioId;
    }

    public void setId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getData_aniversario() {
        return dataAniversario;
    }

    public void setData_aniversario(int ano, int mes, int dia) {
        this.dataAniversario = LocalDate.of(ano, mes, dia);
    }

    public void setData_aniversario(LocalDate dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}