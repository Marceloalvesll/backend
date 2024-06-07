package br.unitins.topicos1.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.BaquetaDTO;
import br.unitins.topicos1.dto.BaquetaResponseDTO;
import br.unitins.topicos1.model.Baqueta;
import br.unitins.topicos1.repository.BaquetaRepository;
import br.unitins.topicos1.repository.CategoriaRepository;
import br.unitins.topicos1.repository.MarcaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BaquetaServiceImpl implements BaquetaService {

    @Inject
    MarcaRepository marcaRepository;

    @Inject
    CategoriaRepository categoriaRepository;

    @Inject
    BaquetaRepository baquetaRepository;

    @Override
    @Transactional
    public BaquetaResponseDTO insert(BaquetaDTO dto) {
        
        Baqueta baqueta = new Baqueta();
        baqueta.setNomeBaqueta(dto.nomeBaqueta());
        baqueta.setDescricao(dto.descricao());
        baqueta.setQuantidadeEstoque(dto.quantidadeEstoque());
        baqueta.setPreco(dto.preco());
        baqueta.setNomeImagem(dto.nomeImagem());
        baqueta.setCategoria(categoriaRepository.findById(dto.IdCategoria()));
        baqueta.setMarca(marcaRepository.findById(dto.IdMarca()));

        baquetaRepository.persist(baqueta);
        return BaquetaResponseDTO.valueOf(baqueta);

    }

    @Override
    @Transactional
    public BaquetaResponseDTO update(BaquetaDTO dto, Long idBaqueta) {
        Baqueta baqueta = baquetaRepository.findById(idBaqueta);
        if (dto.preco() != null)
        baqueta.setPreco(dto.preco());

        if (dto.nomeImagem() != null)
        baqueta.setNomeImagem(dto.nomeImagem());

        if (dto.nomeBaqueta() != null)
        baqueta.setNomeBaqueta(dto.nomeBaqueta());

        if (marcaRepository.findById(dto.IdMarca()) != null)
        baqueta.setMarca(marcaRepository.findById(dto.IdMarca()));

        if (dto.quantidadeEstoque() != null)
        baqueta.setQuantidadeEstoque(dto.quantidadeEstoque());

        if (categoriaRepository.findById(dto.IdCategoria()) != null)
        baqueta.setCategoria(categoriaRepository.findById(dto.IdCategoria()));

        if (dto.descricao() != null)
        baqueta.setDescricao(dto.descricao());


        baquetaRepository.persist(baqueta);
        return BaquetaResponseDTO.valueOf(baqueta);

    }

    @Override
    @Transactional
    public BaquetaResponseDTO findById(Long idBaqueta) {
        return BaquetaResponseDTO.valueOf(baquetaRepository.findById(idBaqueta));
    }

    @Override
    @Transactional
    public void delete(Long idBaqueta) {
        baquetaRepository.deleteById(idBaqueta);
    }

    @Override
    public List<BaquetaResponseDTO> getAll() {

        List<Baqueta> list = baquetaRepository.findAll().list();
        return list.stream().map(e -> BaquetaResponseDTO.valueOf(e)).collect(Collectors.toList());
    }
}
