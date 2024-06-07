package br.unitins.topicos1.repository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import br.unitins.topicos1.model.Acessorio;


@ApplicationScoped
public class AcessorioRepository implements PanacheRepository<Acessorio> {

    public Acessorio findById(Long id) {
        return findByIdOptional(id).orElse(null);
    }


}