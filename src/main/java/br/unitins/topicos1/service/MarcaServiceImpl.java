package br.unitins.topicos1.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.dto.MarcaResponseDTO;
import br.unitins.topicos1.model.Marca;
import br.unitins.topicos1.repository.MarcaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MarcaServiceImpl implements MarcaService {


    @Inject
    MarcaRepository repository;


    @Override
    @Transactional
    public MarcaResponseDTO insertMarca(MarcaDTO dto) {
       Marca novaMarca = new Marca();
        novaMarca.setNomeMarca(dto.nomeMarca());
        novaMarca.setPaisOrigem(dto.paisOrigem());

        repository.persist(novaMarca);
        return MarcaResponseDTO.valueOf(novaMarca);
    }

    @Override
    @Transactional
    public MarcaResponseDTO updateMarca(MarcaDTO dto, Long idMarca) {
        Marca marcaAtualizada = repository.findById(idMarca);
        if (dto.nomeMarca() != null){
            marcaAtualizada.setNomeMarca(dto.nomeMarca()); 
           }

        if (dto.paisOrigem() != null) {
            marcaAtualizada.setPaisOrigem(dto.paisOrigem());
        }
        repository.persist(marcaAtualizada);
        return MarcaResponseDTO.valueOf(marcaAtualizada);
            
    }

    @Override
    @Transactional
    public MarcaResponseDTO findById(Long idMarca) {
         return MarcaResponseDTO.valueOf(repository.findById(idMarca));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
    
    @Override
    public List<MarcaResponseDTO> getAll() {

        List<Marca> list = repository.findAll().list();
        return list.stream().map(e -> MarcaResponseDTO.valueOf(e)).collect(Collectors.toList());
    }
}
