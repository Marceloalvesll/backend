package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Categoria;

public record CategoriaDTO(

        String nomeCategoria

) {

    public Categoria valueOf() {
        Categoria categoria = new Categoria();
        categoria.setNomeCategoria(nomeCategoria());

        return categoria;
    }
}