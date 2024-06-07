package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.TamborAvulsoDTO;
import br.unitins.topicos1.dto.TamborAvulsoResponseDTO;


public interface TamborAvulsoService {
   
    TamborAvulsoResponseDTO insert(TamborAvulsoDTO dto);
    TamborAvulsoResponseDTO update(TamborAvulsoDTO dto, Long idTamborAvulso);
    TamborAvulsoResponseDTO findById(Long idTamborAvulso);
    void delete(Long id);

    List<TamborAvulsoResponseDTO> getAll();
    
}