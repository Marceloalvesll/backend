package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.CupomPromocionalDTO;
import br.unitins.topicos1.dto.CupomPromocionalResponseDTO;


public interface CupomService {
    CupomPromocionalResponseDTO insert(CupomPromocionalDTO dto);

    CupomPromocionalResponseDTO update(CupomPromocionalDTO dto, Long id);

    void delete(Long id);

    CupomPromocionalResponseDTO findById(Long id);

    CupomPromocionalResponseDTO findByCodigo(String codigo);
}
