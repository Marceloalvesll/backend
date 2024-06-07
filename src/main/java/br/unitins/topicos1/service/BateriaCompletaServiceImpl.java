package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.BateriaCompletaDTO;
import br.unitins.topicos1.dto.BateriaCompletaResponseDTO;
import br.unitins.topicos1.model.BateriaCompleta;
import br.unitins.topicos1.repository.BateriaCompletaRepository;
import br.unitins.topicos1.repository.CategoriaRepository;
import br.unitins.topicos1.repository.MarcaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BateriaCompletaServiceImpl implements BateriaCompletaService {
    @Inject
    BateriaCompletaRepository repository;

    @Inject
    MarcaRepository marcaRepository;

    @Inject
    CategoriaRepository categoriaRepository;

   

    @Override
    @Transactional
    public BateriaCompletaResponseDTO insert(BateriaCompletaDTO dto) {


        BateriaCompleta bateriaCompleta = new BateriaCompleta();
        bateriaCompleta.setNomeBateria(dto.nomeBateria());
        bateriaCompleta.setDescricao(dto.descricao());
        bateriaCompleta.setQuantidadeEstoque(dto.quantidadeEstoque());
        bateriaCompleta.setQuantidadeTambor(dto.quantidadeTambor());
        bateriaCompleta.setPreco(dto.preco());
        bateriaCompleta.setNomeImagem(dto.nomeImagem());
        bateriaCompleta.setCategoria(categoriaRepository.findById(dto.IdCategoria()));
        bateriaCompleta.setMarca(marcaRepository.findById(dto.IdMarca()));

        repository.persist(bateriaCompleta);
        return BateriaCompletaResponseDTO.valueOf(bateriaCompleta);

    }

    @Override
    @Transactional
    public BateriaCompletaResponseDTO update(BateriaCompletaDTO dto, Long id) {
        BateriaCompleta bateriaCompleta = repository.findById(id);
        

        if (dto.preco() != null)
        bateriaCompleta.setPreco(dto.preco());

        if (dto.nomeImagem() != null)
        bateriaCompleta.setNomeImagem(dto.nomeImagem());

        if (dto.nomeBateria() != null)
        bateriaCompleta.setNomeBateria(dto.nomeBateria());

        if (marcaRepository.findById(dto.IdMarca()) != null)
        bateriaCompleta.setMarca(marcaRepository.findById(dto.IdMarca()));

        if (dto.quantidadeTambor() != null) 
        bateriaCompleta.setQuantidadeTambor(dto.quantidadeTambor());
        
        if (dto.quantidadeEstoque() != null)
        bateriaCompleta.setQuantidadeEstoque(dto.quantidadeEstoque());

        if (categoriaRepository.findById(dto.IdCategoria()) != null)
        bateriaCompleta.setCategoria(categoriaRepository.findById(dto.IdCategoria()));

        if (dto.descricao() != null)
        bateriaCompleta.setDescricao(dto.descricao());

        repository.persist(bateriaCompleta);
        return BateriaCompletaResponseDTO.valueOf(bateriaCompleta);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public BateriaCompletaResponseDTO findById(Long id) {
        return BateriaCompletaResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<BateriaCompletaResponseDTO> findByName(String nome) {
        return repository.findByName(nome).stream().map(BateriaCompletaResponseDTO::valueOf).toList();
    }

    @Override
    @Transactional
    public void updateNomeImagem(Long id, String nomeImagem) {
        BateriaCompleta bateriaCompleta = repository.findById(id);

        if (bateriaCompleta == null)
            throw new NullPointerException("Nenhuma bateria encontrado");

            bateriaCompleta.setNomeImagem(nomeImagem);

    }

    @Override
    public List<BateriaCompletaResponseDTO> getAll() {

        List<BateriaCompleta> list = repository.findAll().list();
        return list.stream().map(e -> BateriaCompletaResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

  
}
