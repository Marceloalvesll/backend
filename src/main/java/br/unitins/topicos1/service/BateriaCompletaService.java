package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.BateriaCompletaDTO;
import br.unitins.topicos1.dto.BateriaCompletaResponseDTO;

import java.util.List;

public interface BateriaCompletaService {
    BateriaCompletaResponseDTO insert(BateriaCompletaDTO dto);

    BateriaCompletaResponseDTO update(BateriaCompletaDTO dto, Long id);

    void delete(Long id);

    void updateNomeImagem(Long id, String nomeImagem) ;

    BateriaCompletaResponseDTO findById(Long id);

    List<BateriaCompletaResponseDTO> findByName(String nome);

    List<BateriaCompletaResponseDTO> getAll();
}
