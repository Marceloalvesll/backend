package br.unitins.topicos1.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.TamborAvulsoDTO;
import br.unitins.topicos1.dto.TamborAvulsoResponseDTO;
import br.unitins.topicos1.model.TamborAvulso;
import br.unitins.topicos1.repository.CategoriaRepository;
import br.unitins.topicos1.repository.MarcaRepository;
import br.unitins.topicos1.repository.TamborAvulsoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TamborAvulsoServiceImpl implements TamborAvulsoService {

    @Inject
    MarcaRepository marcaRepository;

    @Inject
    CategoriaRepository categoriaRepository;

    @Inject
    TamborAvulsoRepository tamborAvulsoRepository;

    @Override
    @Transactional
    public TamborAvulsoResponseDTO insert(TamborAvulsoDTO dto) {
        
       TamborAvulso tamborAvulso = new TamborAvulso();
       tamborAvulso.setNomeTambor(dto.nomeTambor());
       tamborAvulso.setDescricao(dto.descricao());
       tamborAvulso.setQuantidadeEstoque(dto.quantidadeEstoque());
       tamborAvulso.setPreco(dto.preco());
       tamborAvulso.setNomeImagem(dto.nomeImagem());
       tamborAvulso.setCategoria(categoriaRepository.findById(dto.IdCategoria()));
       tamborAvulso.setMarca(marcaRepository.findById(dto.IdMarca()));

        tamborAvulsoRepository.persist(tamborAvulso);
        return TamborAvulsoResponseDTO.valueOf(tamborAvulso);

    }

    @Override
    @Transactional
    public TamborAvulsoResponseDTO update(TamborAvulsoDTO dto, Long idTamborAvulso) {
        TamborAvulso tamborAvulso = tamborAvulsoRepository.findById(idTamborAvulso);
        if (dto.preco() != null)
        tamborAvulso.setPreco(dto.preco());

        if (dto.nomeImagem() != null)
        tamborAvulso.setNomeImagem(dto.nomeImagem());

        if (dto.nomeTambor() != null)
        tamborAvulso.setNomeTambor(dto.nomeTambor());

        if (marcaRepository.findById(dto.IdMarca()) != null)
        tamborAvulso.setMarca(marcaRepository.findById(dto.IdMarca()));

        if (dto.quantidadeEstoque() != null)
        tamborAvulso.setQuantidadeEstoque(dto.quantidadeEstoque());

        if (categoriaRepository.findById(dto.IdCategoria()) != null)
        tamborAvulso.setCategoria(categoriaRepository.findById(dto.IdCategoria()));

        if (dto.descricao() != null)
        tamborAvulso.setDescricao(dto.descricao());


        tamborAvulsoRepository.persist(tamborAvulso);
        return TamborAvulsoResponseDTO.valueOf(tamborAvulso);

    }

    @Override
    @Transactional
    public TamborAvulsoResponseDTO findById(Long idTamborAvulso) {
        return TamborAvulsoResponseDTO.valueOf(tamborAvulsoRepository.findById(idTamborAvulso));
    }

    @Override
    @Transactional
    public void delete(Long idTamborAvulso) {
        tamborAvulsoRepository.deleteById(idTamborAvulso);
    }

    @Override
    public List<TamborAvulsoResponseDTO> getAll() {

        List<TamborAvulso> list = tamborAvulsoRepository.findAll().list();
        return list.stream().map(e -> TamborAvulsoResponseDTO.valueOf(e)).collect(Collectors.toList());
    }
}
