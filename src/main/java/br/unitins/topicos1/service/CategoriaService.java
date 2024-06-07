package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CategoriaDTO;
import br.unitins.topicos1.dto.CategoriaResponseDTO;


public interface CategoriaService {
   
    CategoriaResponseDTO insert(CategoriaDTO dto);
    CategoriaResponseDTO update(CategoriaDTO dto, Long idCategoria);
    CategoriaResponseDTO findById(Long idCategoria);
    void delete(Long idCategoria);

    List<CategoriaResponseDTO> findAll();
    
}