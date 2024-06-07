package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.CupomPromocional;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CupomRepository implements PanacheRepository<CupomPromocional> {
    public CupomPromocional findByCodigo(String codigo) {
        try {
            return find("LOWER(codigo) = LOWER(?1)", codigo).singleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
