package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.CupomPromocional;
import br.unitins.topicos1.model.ItemPedido;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.TipoPagamento;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoResponseDTO(
        Long id,
        ClienteResponseDTO cliente,
        LocalDateTime data,
        List<ItemPedido> itens,
        TipoPagamento tipoPagamento,
        CupomPromocional cupom,
        Double total,
        List<StatusPedidoResponseDTO> historicoStatus
) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        try {
            return new PedidoResponseDTO(
                    pedido.getId(),
                    ClienteResponseDTO.valueOf(pedido.getCliente()),
                    pedido.getDataCriacao(),
                    pedido.getItensPedido(),
                    pedido.getTipoPagamento(),
                    pedido.getCupomPromocional(),
                    pedido.getTotal(),
                    pedido.getHistoricoStatus().stream().map(StatusPedidoResponseDTO::valueOf).toList()
            );
        } catch (NullPointerException e) {
            return null;
        }
    }
}
