package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Baqueta;


public record BaquetaResponseDTO(
        Long id,
        String nomeBaqueta,
        String descricao,
        String nomeImagem,
        MarcaResponseDTO marca,
        CategoriaResponseDTO categoria,
        Integer quantidadeEstoque,
        Double preco
) {
    public static BaquetaResponseDTO valueOf(Baqueta baqueta) {
        try {
            
                return new BaquetaResponseDTO(
                    baqueta.getId(),
                    baqueta.getNomeBaqueta(), 
                    baqueta.getDescricao(),
                    baqueta.getNomeImagem(),
                    MarcaResponseDTO.valueOf(baqueta.getMarca()), 
                    CategoriaResponseDTO.valueOf(baqueta.getCategoria()),
                    baqueta.getQuantidadeEstoque(),
                    baqueta.getPreco()
            );
        } catch (NullPointerException e) {
            return null;
        }
    }
}
