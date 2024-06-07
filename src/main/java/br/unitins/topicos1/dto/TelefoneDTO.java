package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Telefone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TelefoneDTO(
        @NotBlank
        String numero,
        @NotBlank
        @Size(max = 3, min = 2)
        String codigoArea,

        @NotBlank
        String operadora
) {

    public Telefone valueOf() {
        Telefone novo = new Telefone();
        novo.setCodigoArea(codigoArea());
        novo.setNumero(numero());
        novo.setOperadora(operadora());
        return novo;
    }
}
