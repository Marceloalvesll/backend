package br.unitins.topicos1.service;
import br.unitins.topicos1.dto.AlterarNomeDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.dto.AlterarSobrenomeDTO;
import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;


import java.util.List;

public interface ClienteService {
    ClienteResponseDTO insert(ClienteDTO dto);

    ClienteResponseDTO update(ClienteDTO dto, Long id);

     public ClienteResponseDTO findByLoginAndSenha(String login, String senha);
   
    public void delete(Long id);

    List<ClienteResponseDTO> getAll();

    ClienteResponseDTO findById(Long id);

    List<ClienteResponseDTO> findByName(String nome);

    public ClienteResponseDTO findByLogin(String login);

    public Boolean alterarSenha(AlterarSenhaDTO dto, Long id);

    public Boolean alterarNome(AlterarNomeDTO dto, Long id);

     public Boolean alterarSobrenome(AlterarSobrenomeDTO dto, Long id);

}
