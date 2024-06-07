package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Status;
import br.unitins.topicos1.model.StatusPedido;

import java.time.LocalDateTime;


public record StatusPedidoDTO(
        Status status
) {
    public StatusPedido valueOf() {
        StatusPedido statusPedido = new StatusPedido();
        statusPedido.setStatus(status());
        statusPedido.setData(LocalDateTime.now());
        return statusPedido;
    }
}
