package br.unitins.topicos1.model;

public enum Status {
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    EM_PROCESSAMENTO("Em Processamento"),
    ENVIADO("Enviado"),
    ENTREGUE("Entregue"),
    CANCELADO("Cancelado");

    private final String nome;

    Status(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
