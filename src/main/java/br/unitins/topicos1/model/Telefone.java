package br.unitins.topicos1.model;

import jakarta.persistence.Entity;

@Entity
public class Telefone extends DefaultEntity {

    private String numero;

    private String codigoArea;

    private String operadora;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

}
