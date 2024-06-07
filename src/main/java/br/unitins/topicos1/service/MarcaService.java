package br.unitins.topicos1.service;

import java.util.List;


import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.dto.MarcaResponseDTO;

public interface MarcaService {
   
    MarcaResponseDTO insertMarca(MarcaDTO dto);
    MarcaResponseDTO updateMarca(MarcaDTO dto, Long idMarca);
    MarcaResponseDTO findById(Long idMarca);
    void delete(Long id);

    List<MarcaResponseDTO> getAll();
    
}