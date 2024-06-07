package br.unitins.topicos1.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido extends DefaultEntity {
   
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    private LocalDateTime dataCriacao;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "id_pedido")
    private List<ItemPedido> itensPedido;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cupom")
    private CupomPromocional cupomPromocional;

    private Double total;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_pedido")
    private List<StatusPedido> historicoStatus;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public List<StatusPedido> getHistoricoStatus() {
        return historicoStatus;
    }

    public void setHistoricoStatus(List<StatusPedido> statusPedidos) {
        this.historicoStatus = statusPedidos;
    }

    public CupomPromocional getCupomPromocional() {
        return cupomPromocional;
    }

    public void setCupomPromocional(CupomPromocional cupomPromocional) {
        this.cupomPromocional = cupomPromocional;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
