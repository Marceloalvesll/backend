package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.TelefoneResponseDTO;
import br.unitins.topicos1.model.Administrador;
import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.repository.AdministradorRepository;
import br.unitins.topicos1.repository.ClienteRepository;
import br.unitins.topicos1.repository.TelefoneRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TelefoneServiceImpl implements TelefoneService {

    @Inject
    TelefoneRepository repository;

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    AdministradorRepository administradorRepository;

    @Override
    @Transactional
    public TelefoneResponseDTO insertCliente(TelefoneDTO dto, Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente);
        Telefone telefone = dto.valueOf();
        if (cliente != null) {
            cliente.getTelefone().add(telefone);
            clienteRepository.persistAndFlush(cliente); // se não fizer isso não atualiza o id no objeto adicionado
        }
        return TelefoneResponseDTO.valueOf(telefone);
    }

    @Override
    @Transactional
    public TelefoneResponseDTO insertAdmin(TelefoneDTO dto, Long idAdmin) {
        Administrador administrador = administradorRepository.findById(idAdmin);
        Telefone telefone = dto.valueOf();
        if (administrador != null) {
            administrador.getTelefone().add(telefone);
            administradorRepository.persistAndFlush(administrador); // se não fizer isso não atualiza o id no objeto adicionado
        }
        return TelefoneResponseDTO.valueOf(telefone);
    }

    @Override
    @Transactional
    public TelefoneResponseDTO update(TelefoneDTO dto, Long id) {
        Telefone telefone = repository.findById(id);
        if (dto.operadora() != null) telefone.setOperadora(dto.operadora());
        if (dto.codigoArea() != null) telefone.setCodigoArea(dto.codigoArea());
        if (dto.numero() != null) telefone.setNumero(dto.numero());
        repository.persist(telefone);
        return TelefoneResponseDTO.valueOf(telefone);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public TelefoneResponseDTO findById(Long id) {
        return TelefoneResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public TelefoneResponseDTO findByDDDeNumero(String ddd, String numero) {
        return TelefoneResponseDTO.valueOf(repository.findByDDDeNumero(ddd, numero));
    }
}
