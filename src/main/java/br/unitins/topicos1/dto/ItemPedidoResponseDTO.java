package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.model.ItemPedido;

public record ItemPedidoResponseDTO(
    Integer quantidade,
    Double preco,
    Long idProduto,
    String nome
) { 
    public static ItemPedidoResponseDTO valueOf(ItemPedido ItemPedido){
        return new ItemPedidoResponseDTO(
           ItemPedido.getQuantidade(), 
           ItemPedido.getPrecoUnitario(),
           ItemPedido.getBateriaCompleta().getId(),
           ItemPedido.getBateriaCompleta().getNomeBateria());
    }

    public static List<ItemPedidoResponseDTO> valueOf(List<ItemPedido> ItemPedido) {
       return ItemPedido.stream().map(i -> ItemPedidoResponseDTO.valueOf(i)).toList();
    }

}