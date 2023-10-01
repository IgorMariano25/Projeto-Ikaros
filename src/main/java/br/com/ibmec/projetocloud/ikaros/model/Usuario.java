package br.com.ibmec.projetocloud.ikaros.model;

import java.time.LocalDate;
import java.util.List;

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
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "sobrenome", nullable = false, length = 100)
    private String sobrenome;

    @Column(name = "data_aniversairo", nullable = false)
    private LocalDate data_aniversario;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "senha", nullable = false, length = 45)
    private String senha;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private List<Comentario> comentarios;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private List<Postagem> postagens; 

    public List<Comentario> getComentarios(){
        return comentarios;
    }

    public List<Postagem> getPostagens(){
        return postagens;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }

    public void addComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    public void addPostagem(Postagem postagem) {
        this.postagens.add(postagem);
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
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

    public void setData_aniversario(int ano, int mes, int dia) {
        this.data_aniversario = LocalDate.of(ano, mes, dia);
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

    public static Usuario buscarUsuarioPorId(Integer id) {
        if (id != null) {
            Usuario usuario = new Usuario();
            return usuario;
        } else {
            return null;
        }
    }
}
