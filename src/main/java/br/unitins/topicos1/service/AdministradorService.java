package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.AdministradorDTO;
import br.unitins.topicos1.dto.AdministradorResponseDTO;
import br.unitins.topicos1.dto.AlterarCargoDTO;
import br.unitins.topicos1.dto.AlterarNomeDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;

import java.util.List;

public interface AdministradorService {
    AdministradorResponseDTO insert(AdministradorDTO dto);

    AdministradorResponseDTO update(AdministradorDTO dto, Long id);

    void delete(Long id);

    public AdministradorResponseDTO findByLoginAndSenha(String login, String senha);

    
    public AdministradorResponseDTO findByLogin(String login);

    AdministradorResponseDTO findById(Long id);

    List<AdministradorResponseDTO> findByName(String nome);

    public Boolean alterarSenha(AlterarSenhaDTO dto, Long id);

     public Boolean alterarNome(AlterarNomeDTO dto, Long id);

     public Boolean alterarCargo(AlterarCargoDTO dto, Long id);

    
}
