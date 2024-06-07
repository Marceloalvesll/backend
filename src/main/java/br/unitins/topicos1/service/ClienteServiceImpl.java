package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.AlterarNomeDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.dto.AlterarSobrenomeDTO;
import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.repository.ClienteRepository;
import br.unitins.topicos1.repository.EnderecoRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    ClienteRepository repository;

    @Inject
    HashService hashService;


    @Override
    @Transactional
    public ClienteResponseDTO insert(ClienteDTO dto) {
        Cliente novo = new Cliente();
        novo.setCpf(dto.cpf());
        novo.setEmail(dto.email());
        novo.setNome(dto.nome());
        novo.setSobrenome(dto.sobrenome());
        novo.setDataNascimento(dto.dataNascimento());
        novo.setEndereco(dto.enderecos().stream().map(EnderecoDTO::valueOf).toList());
        novo.setSenha(hashService.getHashSenha(dto.senha()));
        novo.setLogin(dto.login());
        novo.setTelefone(dto.telefones().stream().map(TelefoneDTO::valueOf).toList());

        repository.persist(novo);
        return ClienteResponseDTO.valueOf(novo);
    }

    @Override
    @Transactional
    public ClienteResponseDTO update(ClienteDTO dto, Long id) {
        Cliente cliente = repository.findById(id);
        if (dto.nome() != null) 
        cliente.setNome(dto.nome());
        if (dto.senha() != null) 
        cliente.setSenha(dto.senha());
        if (dto.email() != null) 
        cliente.setEmail(dto.email());
        if (dto.cpf() != null) 
        cliente.setCpf(dto.cpf());
        if (dto.telefones() != null) 
        cliente.setTelefone(dto.telefones().stream().map(TelefoneDTO::valueOf).toList());
        if (dto.enderecos() != null)
         cliente.setEndereco(dto.enderecos().stream().map(EnderecoDTO::valueOf).toList());
        if (dto.dataNascimento() != null)
         cliente.setDataNascimento(dto.dataNascimento());
        if (dto.login() != null) 
        cliente.setLogin(dto.login());
        if (dto.sobrenome() != null)
         cliente.setSobrenome(dto.sobrenome());
        repository.persist(cliente);
        return ClienteResponseDTO.valueOf(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        return ClienteResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<ClienteResponseDTO> findByName(String nome) {
        return repository.findByName(nome).stream().map(ClienteResponseDTO::valueOf).toList();
    }

    @Override
    public ClienteResponseDTO findByLoginAndSenha(String login, String senha) {
        Cliente cliente = repository.findByLoginAndSenha(login, senha);
        if (cliente == null) 
            throw new ValidationException("login", "Login ou senha inválido");

        return ClienteResponseDTO.valueOf(cliente);
    }

        @Override
    public ClienteResponseDTO findByLogin(String login) {
        Cliente cliente = repository.findByLogin(login);
        if (cliente == null) 
            throw new ValidationException("login", "Login inválido");

        return ClienteResponseDTO.valueOf(cliente);
}

 @Override
    @Transactional
    public Boolean alterarSenha(AlterarSenhaDTO dto, Long id) {
        Cliente cliente = repository.findById(id);
        if(cliente != null){
            if(hashService.getHashSenha(dto.antigaSenha()).equals(cliente.getSenha())){
                cliente.setSenha(hashService.getHashSenha(dto.novaSenha()));
                repository.persist(cliente);
                return true;
            }
        }
        return false;
    }


     @Override
    @Transactional
    public Boolean alterarNome(AlterarNomeDTO dto, Long id) {
        Cliente cliente = repository.findById(id);
        if(cliente != null){
                cliente.setNome(dto.nomeNovo());
                repository.persist(cliente);
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean alterarSobrenome(AlterarSobrenomeDTO dto, Long id) {
        Cliente cliente = repository.findById(id);
        if(cliente != null){
               cliente.setSobrenome(dto.sobrenomeNovo());
                repository.persist(cliente);
        }
        return false;
    }

    @Override
    public List<ClienteResponseDTO> getAll() {

        List<Cliente> list = repository.findAll().list();
        return list.stream().map(e -> ClienteResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    
    
}
