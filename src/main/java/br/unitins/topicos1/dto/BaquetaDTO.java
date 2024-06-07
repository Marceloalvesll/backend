package br.unitins.topicos1.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record BaquetaDTO(
        @NotBlank
        String nomeBaqueta,
        @NotBlank
        String descricao,
        @NotNull
        @PositiveOrZero
        Double preco,
        @NotNull
        @PositiveOrZero
        Integer quantidadeEstoque,
        @NotNull
        Long IdMarca,
        @NotBlank
        String nomeImagem,
        @NotNull
        Long IdCategoria
) {

}
