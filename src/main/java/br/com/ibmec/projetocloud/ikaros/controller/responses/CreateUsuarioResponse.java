package br.com.ibmec.projetocloud.ikaros.controller.responses;

public class CreateUsuarioResponse {

    private String nome;
    private String sobrenome;

    public String getNome() {
        return this.nome;
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
}
