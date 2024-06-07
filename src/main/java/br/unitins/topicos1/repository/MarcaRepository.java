package br.unitins.topicos1.repository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import br.unitins.topicos1.model.Marca;

@ApplicationScoped
public class MarcaRepository implements PanacheRepository<Marca> {

    public Marca findById(Long id) {
        return findByIdOptional(id).orElse(null);
    }

}