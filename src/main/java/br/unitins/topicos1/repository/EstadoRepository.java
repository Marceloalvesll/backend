package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Estado;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstadoRepository {
    
    public Estado[] findAll() {
        Estado[] data = Estado.values();
        return data;
    }


  
}
