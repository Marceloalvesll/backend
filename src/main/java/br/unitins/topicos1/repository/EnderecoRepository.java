package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {

    public List<Endereco> findByCep(String cep) {
        return find("cep = ?1", cep).list();
    }

    public List<Endereco> findByIdUser(Long idCliente) {
        return find("id_cliente = ?1", idCliente).list();
    }

    @Transactional
    public void delete(Long idCliente) {
        delete("id_cliente", idCliente);
    }
    

    // public boolean delete(Long id) {
    //     try {
    //         //desfazer as relações antes de deletar
    //         getEntityManager().createNativeQuery(
    //                 "delete from cliente_endereco where id_endereco = " + id
    //         ).executeUpdate();


    //         return deleteById(id);
    //     } catch (Exception e) {
    //         return false;
    //     }
    // }
}
