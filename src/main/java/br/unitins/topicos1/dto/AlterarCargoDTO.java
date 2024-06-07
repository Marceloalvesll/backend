package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Size;

public record AlterarCargoDTO(
        @Size
        (min = 10) String CargoNovo
) {

}

