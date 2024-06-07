package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.AcessorioDTO;
import br.unitins.topicos1.dto.AcessorioResponseDTO;
import br.unitins.topicos1.model.Acessorio;
import br.unitins.topicos1.repository.AcessorioRepository;
import br.unitins.topicos1.repository.CategoriaRepository;
import br.unitins.topicos1.repository.MarcaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AcessorioServiceImpl implements AcessorioService {
    @Inject
    AcessorioRepository repository;

    @Inject
    MarcaRepository marcaRepository;

    @Inject
    CategoriaRepository categoriaRepository;

   

    @Override
    @Transactional
    public AcessorioResponseDTO insert(AcessorioDTO dto) {


        Acessorio acessorio = new Acessorio();
        acessorio.setNomeAcessorio(dto.nomeAcessorio());
        acessorio.setDescricao(dto.descricao());
        acessorio.setQuantidadeEstoque(dto.quantidadeEstoque());
        acessorio.setPreco(dto.preco());
        acessorio.setNomeImagem(dto.nomeImagem());
        acessorio.setCategoria(categoriaRepository.findById(dto.IdCategoria()));
        acessorio.setMarca(marcaRepository.findById(dto.IdMarca()));

        repository.persist(acessorio);
        return AcessorioResponseDTO.valueOf(acessorio);

    }

    @Override
    @Transactional
    public AcessorioResponseDTO update(AcessorioDTO dto, Long idAcessorio) {
        Acessorio acessorio = repository.findById(idAcessorio);
        

        if (dto.preco() != null)
        acessorio.setPreco(dto.preco());

        if (dto.nomeImagem() != null)
        acessorio.setNomeImagem(dto.nomeImagem());

        if (dto.nomeAcessorio() != null)
        acessorio.setNomeAcessorio(dto.nomeAcessorio());

        if (marcaRepository.findById(dto.IdMarca()) != null)
        acessorio.setMarca(marcaRepository.findById(dto.IdMarca()));

        if (dto.quantidadeEstoque() != null)
        acessorio.setQuantidadeEstoque(dto.quantidadeEstoque());

        if (categoriaRepository.findById(dto.IdCategoria()) != null)
        acessorio.setCategoria(categoriaRepository.findById(dto.IdCategoria()));

        if (dto.descricao() != null)
        acessorio.setDescricao(dto.descricao());

        repository.persist(acessorio);
        return AcessorioResponseDTO.valueOf(acessorio);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public AcessorioResponseDTO findById(Long idAcessorio) {
        return AcessorioResponseDTO.valueOf(repository.findById(idAcessorio));
    }

 

    @Override
    @Transactional
    public void updateNomeImagem(Long idAcessorio, String nomeImagem) {
        Acessorio acessorio = repository.findById(idAcessorio);

        if (acessorio == null)
            throw new NullPointerException("Nenhum acessorio encontrado");

            acessorio.setNomeImagem(nomeImagem);

    }

    @Override
    public List<AcessorioResponseDTO> getAll() {

        List<Acessorio> list = repository.findAll().list();
        return list.stream().map(e -> AcessorioResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

  
}
