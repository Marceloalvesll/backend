package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record AdministradorDTO(
    
        @NotBlank String nome,
        @NotBlank String login,
        @NotBlank @CPF String cpf,
        @NotBlank @Email String email,
        @NotBlank @Size(min = 8, message = "A senha precisa ter pelo menos 8 caracteres") String senha,
        @NotBlank String cargo,
        @Size(min = 1) List<TelefoneDTO> telefones) {


}
