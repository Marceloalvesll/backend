package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido extends DefaultEntity {

    private int quantidade;

    private Double precoUnitario;

    @Column(length = 10)
    private Double subTotal;

    @ManyToOne
    @JoinColumn(name = "id_bateriaCompleta")
    private BateriaCompleta bateriaCompleta;
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public BateriaCompleta getBateriaCompleta() {
        return bateriaCompleta;
    }

    public void setProduto(BateriaCompleta bateriaCompleta) {
        this.bateriaCompleta = bateriaCompleta;
    }


    

}
