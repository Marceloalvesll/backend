package br.unitins.topicos1.model;

public enum TipoPagamento {

  
    CARTAO_DE_CREDITO(1, "Cartão de Crédito"),
    CARTAO_DE_DEBITO(2, "Cartão de Débito"),
    BOLETO_BANCARIO(3, "Boleto Bancário"),
    TRANSFERENCIA_BANCARIA(4, "Transferência Bancária"),
    PIX(5, "Pix");

    private final Integer idPagamento;
    private final String nome;


    private TipoPagamento(Integer idPagamento, String nome) {
        this.idPagamento = idPagamento;
        this.nome = nome;
    }

 

    public Integer getIdPagamento() {
        return idPagamento;
    }



    public String getNome() {
        return nome;
    }

    public static TipoPagamento valueOf(Integer id) {
        if (id == null)
            return null;
        for (TipoPagamento tipoPagamento : TipoPagamento.values()) {
            if (tipoPagamento.getIdPagamento().equals(id))
                return tipoPagamento;
        }
        throw new IllegalArgumentException("Id inválido" + id);
    }
}
