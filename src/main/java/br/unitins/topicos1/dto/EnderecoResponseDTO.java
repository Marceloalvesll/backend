package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Estado;

public record EnderecoResponseDTO(
        Long id,
        String rua,
        Integer numero,
        String cidade,
        String cep,
        Estado estado
) {
    public static EnderecoResponseDTO valueOf(Endereco endereco) {
        try {
            return new EnderecoResponseDTO(
                    endereco.getId(),
                    endereco.getRua(),
                    endereco.getNumero(),
                    endereco.getCidade(),
                    endereco.getCep(),
                    endereco.getEstado()
            );
        } catch (NullPointerException e) {
            return null;
        }

    }
}
