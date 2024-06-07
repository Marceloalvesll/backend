package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.CupomPromocionalDTO;
import br.unitins.topicos1.dto.CupomPromocionalResponseDTO;
import br.unitins.topicos1.model.CupomPromocional;
import br.unitins.topicos1.repository.CupomRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CupomServiceImpl implements CupomService {

    @Inject
    CupomRepository repository;

    @Override
    @Transactional
    public CupomPromocionalResponseDTO insert(CupomPromocionalDTO dto) {
        CupomPromocional cupom = dto.valueOf();
        repository.persist(cupom);
        return CupomPromocionalResponseDTO.valueOf(cupom);
    }

    @Override
    @Transactional
    public CupomPromocionalResponseDTO update(CupomPromocionalDTO dto, Long id) {
        CupomPromocional cupom = repository.findById(id);
        if (dto.codigo() != null) cupom.setCodigo(dto.codigo());
        if (dto.dataExpiracao() != null) cupom.setDataExpiracao(dto.dataExpiracao());
        if (dto.valorDesconto() != null) cupom.setValorDesconto(dto.valorDesconto());
        repository.persist(cupom);
        return CupomPromocionalResponseDTO.valueOf(cupom);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CupomPromocionalResponseDTO findById(Long id) {
        return CupomPromocionalResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public CupomPromocionalResponseDTO findByCodigo(String codigo) {
        return CupomPromocionalResponseDTO.valueOf(repository.findByCodigo(codigo));
    }
}
