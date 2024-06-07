package br.unitins.topicos1.model;


import jakarta.persistence.Entity;


@Entity
public class Categoria extends DefaultEntity {

    private String nomeCategoria;

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

}
