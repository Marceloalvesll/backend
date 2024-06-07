package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Size;

public record AlterarNomeDTO(
        @Size
        (min = 4) String nomeNovo
) {

}


