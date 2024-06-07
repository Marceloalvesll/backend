package br.unitins.topicos1.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Administrador extends DefaultEntity {
    private String nome;
    private String login;
    private String cpf;
    private String email;

    private String senha;
    private String cargo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "administrador_telefone",
            joinColumns = @JoinColumn(name = "id_administrador"),
            inverseJoinColumns = @JoinColumn(name = "id_telefone"))
    private List<Telefone> telefone;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
