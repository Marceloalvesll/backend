package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.EnderecoResponseDTO;

import java.util.List;

public interface EnderecoService {
    EnderecoResponseDTO insert(EnderecoDTO dto, Long idCliente);

    EnderecoResponseDTO update(EnderecoDTO dto, Long id);

    void delete(Long id);

    EnderecoResponseDTO findById(Long id);

    List<EnderecoResponseDTO> findByCep(String cep);


      List<EnderecoResponseDTO> getAll();

}
