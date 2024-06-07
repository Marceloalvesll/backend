package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.AcessorioDTO;
import br.unitins.topicos1.dto.AcessorioResponseDTO;


import java.util.List;

public interface AcessorioService {
    AcessorioResponseDTO insert(AcessorioDTO dto);

    AcessorioResponseDTO update(AcessorioDTO dto, Long idAcessorio);

    void delete(Long idAcessorio);

    void updateNomeImagem(Long idAcessorio, String nomeImagem) ;

    AcessorioResponseDTO findById(Long idAcessorio);

    List<AcessorioResponseDTO> getAll();
}
