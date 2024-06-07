package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Telefone;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TelefoneRepository implements PanacheRepository<Telefone> {
    public Telefone findByDDDeNumero(String ddd, String numero) {
        return find("codigoArea = ?1 AND numero = ?2", ddd, numero).singleResult();
    }

    public List<Telefone> findByIdUser(Long idCliente) {
        return find("cliente.id = ?1", idCliente).list();
    }

    public boolean delete(Long id) {
        try {
            //desfazer as relações antes de deletar
            getEntityManager().createNativeQuery(
                    "delete from cliente_telefone where id_telefone = " + id
            ).executeUpdate();
            getEntityManager().createNativeQuery(
                    "delete from administrador_telefone where id_telefone = " + id
            ).executeUpdate();


            return deleteById(id);
        } catch (Exception e) {
            return false;
        }
    }
}
