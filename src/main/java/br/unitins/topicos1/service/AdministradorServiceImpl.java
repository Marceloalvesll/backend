package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.AdministradorDTO;
import br.unitins.topicos1.dto.AdministradorResponseDTO;
import br.unitins.topicos1.dto.AlterarCargoDTO;
import br.unitins.topicos1.dto.AlterarNomeDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.model.Administrador;
import br.unitins.topicos1.repository.AdministradorRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class AdministradorServiceImpl implements AdministradorService {

    @Inject
    AdministradorRepository adminRepository;

    @Inject
    HashService hashService;

    @Override
    @Transactional
    public AdministradorResponseDTO insert(AdministradorDTO dto) {
        Administrador novo = new Administrador();
        novo.setCargo(dto.cargo());
        novo.setCpf(dto.cpf());
        novo.setLogin(dto.login());
        novo.setEmail(dto.email());
        novo.setNome(dto.nome());
        novo.setSenha(hashService.getHashSenha(dto.senha()));
        novo.setTelefone(dto.telefones().stream().map(TelefoneDTO::valueOf).toList());
        adminRepository.persist(novo);
        return AdministradorResponseDTO.valueOf(novo);

    }

    @Override
    @Transactional
    public AdministradorResponseDTO update(AdministradorDTO dto, Long id) {
        Administrador admin = adminRepository.findById(id);
        if (dto.nome() != null)
            admin.setNome(dto.nome());
        if (dto.senha() != null)
            admin.setSenha(dto.senha());
        if (dto.cargo() != null)
            admin.setCargo(dto.cargo());
        if (dto.email() != null)
            admin.setEmail(dto.email());
        if (dto.nome() != null)
            admin.setCpf(dto.cpf());
        if (dto.telefones() != null)
            admin.setTelefone(dto.telefones().stream().map(TelefoneDTO::valueOf).toList());
        adminRepository.persist(admin);
        return AdministradorResponseDTO.valueOf(admin);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public AdministradorResponseDTO findById(Long id) {
        return AdministradorResponseDTO.valueOf(adminRepository.findById(id));
    }

    @Override
    public List<AdministradorResponseDTO> findByName(String nome) {
        return adminRepository.findByName(nome).stream().map(AdministradorResponseDTO::valueOf).toList();
    }

    @Override
    public AdministradorResponseDTO findByLoginAndSenha(String login, String senha) {
        Administrador administrador = adminRepository.findByLoginAndSenha(login, senha);
        if (administrador == null)
            throw new ValidationException("login", "Login ou senha inválido");

        return AdministradorResponseDTO.valueOf(administrador);
    }

 
    @Override
    public AdministradorResponseDTO findByLogin(String login) {
        Administrador administrador = adminRepository.findByLogin(login);
        if (administrador == null)
            throw new ValidationException("login", "Login inválido");

        return AdministradorResponseDTO.valueOf(administrador);
    }

     @Override
    @Transactional
    public Boolean alterarSenha(AlterarSenhaDTO dto, Long id) {
        Administrador admin = adminRepository.findById(id);
        if(admin != null){
            if(hashService.getHashSenha(dto.antigaSenha()).equals(admin.getSenha())){
                admin.setSenha(hashService.getHashSenha(dto.novaSenha()));
                adminRepository.persist(admin);
                return true;
            }
        }
        return false;
    }

         @Override
    @Transactional
    public Boolean alterarNome(AlterarNomeDTO dto, Long id) {
        Administrador admin = adminRepository.findById(id);
        if(admin != null){
                admin.setNome(dto.nomeNovo());
                adminRepository.persist(admin);
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean alterarCargo(AlterarCargoDTO dto, Long id) {
        Administrador admin = adminRepository.findById(id);
        if(admin != null){
               admin.setCargo(dto.CargoNovo());
                adminRepository.persist(admin);
        }
        return false;
    }

}


