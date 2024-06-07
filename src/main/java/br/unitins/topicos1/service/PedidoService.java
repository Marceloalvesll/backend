package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.dto.StatusPedidoDTO;

import java.util.List;

public interface PedidoService {
    PedidoResponseDTO insert(PedidoDTO dto, String login);

    PedidoResponseDTO update(PedidoDTO dto, Long id);

    PedidoResponseDTO insertStatus(StatusPedidoDTO dto, Long id);

    void delete(Long id);


    PedidoResponseDTO findById(Long id);

    List<PedidoResponseDTO> findByClienteId(Long idCliente);


}
