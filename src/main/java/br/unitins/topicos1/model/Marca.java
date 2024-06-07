package br.unitins.topicos1.model;

import jakarta.persistence.Entity;

@Entity
public class Marca extends DefaultEntity  {

    private String nomeMarca;
    private String paisOrigem;
   
    public String getNomeMarca() {
        return nomeMarca;
    }
    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }
    public String getPaisOrigem() {
        return paisOrigem;
    }
    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    
}
 
