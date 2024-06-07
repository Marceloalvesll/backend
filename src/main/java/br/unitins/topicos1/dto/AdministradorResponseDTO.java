package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Administrador;

import java.util.List;

public record AdministradorResponseDTO(
        Long id,
        String nome,
        String login,
        String cpf,
        String email,
        String cargo,
        List<TelefoneResponseDTO> telefones
) {

    public static AdministradorResponseDTO valueOf(Administrador admin) {
        try {
            return new AdministradorResponseDTO(
                    admin.getId(),
                    admin.getNome(),
                    admin.getLogin(),
                    admin.getCpf(),
                    admin.getEmail(),
                    admin.getCargo(),
                    admin.getTelefone().stream().map(TelefoneResponseDTO::valueOf).toList()
            );
        } catch (NullPointerException e) {
            return null;
        }

    }

}
