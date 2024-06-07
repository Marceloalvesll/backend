package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Marca;



public record MarcaDTO(
      
        String nomeMarca,
      
        String paisOrigem
) {

    public Marca valueOf() {
        Marca novaMarca = new Marca();
        novaMarca.setNomeMarca(nomeMarca());
        novaMarca.setPaisOrigem(paisOrigem());
        
        return novaMarca;
    }
}