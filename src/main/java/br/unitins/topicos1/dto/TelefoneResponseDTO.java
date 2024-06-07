package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Telefone;

public record TelefoneResponseDTO(
        Long id,
        String numero,
        String codigoArea,
        String operadora
) {
    public static TelefoneResponseDTO valueOf(Telefone telefone) {
        try {
            return new TelefoneResponseDTO(
                    telefone.getId(),
                    telefone.getNumero(),
                    telefone.getCodigoArea(),
                    telefone.getOperadora()
            );
        } catch (NullPointerException e) {
            return null;
        }

    }
}
