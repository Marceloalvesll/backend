package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.TamborAvulso;


public record TamborAvulsoResponseDTO(
        Long id,
        String nomeTambor,
        String descricao,
        String nomeImagem,
        MarcaResponseDTO marca,
        CategoriaResponseDTO categoria,
        Integer quantidadeEstoque,
        Double preco
) {
    public static TamborAvulsoResponseDTO valueOf(TamborAvulso tamborAvulso) {
        try {
            
                return new TamborAvulsoResponseDTO(
                    tamborAvulso.getId(),
                    tamborAvulso.getNomeTambor(), 
                    tamborAvulso.getDescricao(),
                    tamborAvulso.getNomeImagem(),
                    MarcaResponseDTO.valueOf(tamborAvulso.getMarca()), 
                    CategoriaResponseDTO.valueOf(tamborAvulso.getCategoria()),
                    tamborAvulso.getQuantidadeEstoque(),
                    tamborAvulso.getPreco()
            );
        } catch (NullPointerException e) {
            return null;
        }
    }
}
