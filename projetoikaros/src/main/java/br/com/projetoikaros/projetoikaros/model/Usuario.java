package br.com.projetoikaros.projetoikaros.model;

import java.time.LocalDate;

public class Usuario {
    private Integer id;
    private String nome;
    private String sobrenome;
    private LocalDate data_aniversario;
    private String email;
    private String senha;

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
        return data_aniversario;
    }

    public void setData_aniversario(LocalDate data_aniversario) {
        this.data_aniversario = data_aniversario;
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
