package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Cliente;

import java.time.LocalDate;
import java.util.List;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String sobrenome,
        LocalDate dataNascimento,
        String cpf,
        String email,
        String login,
        List<EnderecoResponseDTO> enderecos,
        List<TelefoneResponseDTO> telefones

) {
    public static ClienteResponseDTO valueOf(Cliente cliente) {
        try {
            return new ClienteResponseDTO(
                    cliente.getId(),
                    cliente.getNome(),
                    cliente.getSobrenome(),
                    cliente.getDataNascimento(),
                    cliente.getCpf(),
                    cliente.getEmail(),
                    cliente.getLogin(),
                    cliente.getEndereco().stream().map(EnderecoResponseDTO::valueOf).toList(),
                    cliente.getTelefone().stream().map(TelefoneResponseDTO::valueOf).toList()
            );
        } catch (NullPointerException e) {
            return null;
        }
    }
}
