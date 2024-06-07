package br.unitins.topicos1.dto;


import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

public record ClienteDTO(@NotBlank String nome,
                          String sobrenome,
                         @Past  LocalDate dataNascimento,
                         @NotBlank @CPF(message = "CPF Inválido") String cpf,
                          @Email(message = "Email Inválido") String email,
                         @NotBlank String login,
                         @NotBlank @Size(min = 8, message = "A senha precisa ter pelo menos 8 caracteres") String senha,
                         List<EnderecoDTO> enderecos,
                         List<TelefoneDTO> telefones) {

}
