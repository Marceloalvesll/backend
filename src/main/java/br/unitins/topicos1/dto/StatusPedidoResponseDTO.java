package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Status;
import br.unitins.topicos1.model.StatusPedido;

import java.time.LocalDateTime;

public record StatusPedidoResponseDTO(
        LocalDateTime data,
        Status status
) {

    public static StatusPedidoResponseDTO valueOf(StatusPedido statusPedido) {
        return new StatusPedidoResponseDTO(statusPedido.getData(), statusPedido.getStatus());
    }
}
