package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoDTO(
        @NotBlank
        String rua,
        @NotNull
        Integer numero,
        @NotBlank
        String cidade,
        @NotBlank
        String cep,
        
        Integer idEstado
) {

    public Endereco valueOf() {
        Endereco novo = new Endereco();
        novo.setCep(cep());
        novo.setCidade(cidade());
        novo.setEstado(Estado.valueOf(idEstado()));
        novo.setNumero(numero());
        novo.setRua(rua());
        return novo;
    }
}




// public UsuarioResponseDTO insert(@Valid UsuarioDTO dto) {

//     if (repository.findByLogin(dto.login()) != null) {
//         throw new ValidationException("login", "Login já existe.");
//     }

//     try {

//         Usuario novoUsuario = new Usuario();
//         novoUsuario.setNome(dto.nome());
//         novoUsuario.setLogin(dto.login());

//         novoUsuario.setSenha(hashService.getHashSenha(dto.senha()));
//         novoUsuario.setCpf(dto.cpf());
//         novoUsuario.setPerfil(Perfil.valueOf(dto.idPerfil()));

//         repository.persist(novoUsuario);

//         return UsuarioResponseDTO.valueOf(novoUsuario);
//     } catch (Exception e) {
//         throw new RuntimeException("Erro ao inserir usuário", e);
//     }

// }