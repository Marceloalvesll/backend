package br.unitins.topicos1.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.CategoriaDTO;
import br.unitins.topicos1.dto.CategoriaResponseDTO;
import br.unitins.topicos1.model.Categoria;
import br.unitins.topicos1.repository.CategoriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CategoriaServiceImpl implements CategoriaService {


    @Inject
    CategoriaRepository categoriaRepository;

    @Override
    @Transactional
    public CategoriaResponseDTO insert(CategoriaDTO dto) {
        Categoria categoria = new Categoria();

        categoria.setNomeCategoria(dto.nomeCategoria());

        categoriaRepository.persist(categoria);

        return CategoriaResponseDTO.valueOf(categoria);
    }

    @Override
    @Transactional
    public CategoriaResponseDTO update(CategoriaDTO dto, Long idCategoria) {
       Categoria categoriaAtualizada = categoriaRepository.findById(idCategoria);
        
       if(dto.nomeCategoria() != null)
       categoriaAtualizada.setNomeCategoria(dto.nomeCategoria());


       categoriaRepository.persist(categoriaAtualizada);
       return CategoriaResponseDTO.valueOf(categoriaAtualizada);
    }

    @Override
    @Transactional
    public CategoriaResponseDTO findById(Long idCategoria) {
        return CategoriaResponseDTO.valueOf(categoriaRepository.findById(idCategoria));
    }
    @Transactional
    @Override
    public void delete(Long idCategoria) {
       categoriaRepository.deleteById(idCategoria);
    }

    @Override
    public List<CategoriaResponseDTO> findAll() {
         List<Categoria> list = categoriaRepository.findAll().list();
        return list.stream().map(e -> CategoriaResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

}
