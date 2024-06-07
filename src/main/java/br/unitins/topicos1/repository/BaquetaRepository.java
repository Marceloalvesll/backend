package br.unitins.topicos1.repository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import br.unitins.topicos1.model.Baqueta;

@ApplicationScoped
public class BaquetaRepository implements PanacheRepository<Baqueta> {

    public Baqueta findById(Long id) {
        return findByIdOptional(id).orElse(null);
    }

}