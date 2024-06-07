package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Size;

public record AlterarSobrenomeDTO(
        @Size
        (min = 4) String sobrenomeNovo
) {

}

