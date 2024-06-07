package br.unitins.topicos1.repository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import br.unitins.topicos1.model.TamborAvulso;


@ApplicationScoped
public class TamborAvulsoRepository implements PanacheRepository<TamborAvulso> {

    public TamborAvulso findById(Long id) {
        return findByIdOptional(id).orElse(null);
    }


}