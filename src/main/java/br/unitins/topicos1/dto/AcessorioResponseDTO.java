package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Acessorio;


public record AcessorioResponseDTO(
        Long id,
        String nomeAcessorio,
        String descricao,
        String nomeImagem,
        MarcaResponseDTO marca,
        CategoriaResponseDTO categoria,
        Integer quantidadeEstoque,
        Double preco
) {
    public static AcessorioResponseDTO valueOf(Acessorio acessorio) {
        try {
            
                return new AcessorioResponseDTO(
                    acessorio.getId(),
                    acessorio.getNomeAcessorio(), 
                    acessorio.getDescricao(),
                    acessorio.getNomeImagem(),
                    MarcaResponseDTO.valueOf(acessorio.getMarca()), 
                    CategoriaResponseDTO.valueOf(acessorio.getCategoria()),
                    acessorio.getQuantidadeEstoque(),
                    acessorio.getPreco()
            );
        } catch (NullPointerException e) {
            return null;
        }
    }
}
