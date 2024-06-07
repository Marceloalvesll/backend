package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.BaquetaDTO;
import br.unitins.topicos1.dto.BaquetaResponseDTO;


public interface BaquetaService {
   
    BaquetaResponseDTO insert(BaquetaDTO dto);
    BaquetaResponseDTO update(BaquetaDTO dto, Long idBaqueta);
    BaquetaResponseDTO findById(Long idBaqueta);
    void delete(Long idBaqueta);

    List<BaquetaResponseDTO> getAll();
    
}