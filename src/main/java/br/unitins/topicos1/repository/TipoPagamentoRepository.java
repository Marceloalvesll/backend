package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.TipoPagamento;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class TipoPagamentoRepository  {

    public TipoPagamento[] findAll() {
        TipoPagamento[] data = TipoPagamento.values();
        return data;
    }

 }


