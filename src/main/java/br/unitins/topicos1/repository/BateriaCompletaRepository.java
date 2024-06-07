package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.BateriaCompleta;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BateriaCompletaRepository implements PanacheRepository<BateriaCompleta> {
    public List<BateriaCompleta> findByName(String nome) {
        return find("LOWER(nomeBateria) LIKE LOWER(?1)", "%" + nome + "%").list();
    }

    
}
