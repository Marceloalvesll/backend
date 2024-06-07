package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.BateriaCompleta;


public record BateriaCompletaResponseDTO(
        Long id,
        String nomeBateria,
        String descricao,
        String nomeImagem,
        MarcaResponseDTO marca,
        CategoriaResponseDTO categoria,
        Integer quantidadeEstoque,
        Integer quantidadeTambor,
        Double preco
) {
    public static BateriaCompletaResponseDTO valueOf(BateriaCompleta bateriaCompleta) {
        try {
            
                return new BateriaCompletaResponseDTO(
                    bateriaCompleta.getId(),
                    bateriaCompleta.getNomeBateria(), 
                    bateriaCompleta.getDescricao(),
                    bateriaCompleta.getNomeImagem(),
                    MarcaResponseDTO.valueOf(bateriaCompleta.getMarca()), 
                    CategoriaResponseDTO.valueOf(bateriaCompleta.getCategoria()),
                    bateriaCompleta.getQuantidadeEstoque(),
                    bateriaCompleta.getQuantidadeTambor(),
                    bateriaCompleta.getPreco()
            );
        } catch (NullPointerException e) {
            return null;
        }
    }
}
