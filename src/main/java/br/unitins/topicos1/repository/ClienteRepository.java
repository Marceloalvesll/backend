package br.unitins.topicos1.repository;


import br.unitins.topicos1.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;

import java.util.List;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {
    public List<Cliente> findByName(String nome) {
        return find("LOWER(nome) LIKE LOWER(?1)", "%" + nome + "%").list();
    }

     public Cliente findByLogin(String login) {
        try {
            return find("login = ?1", login ).singleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cliente findByLoginAndSenha(String login, String senha) {
        try {
            return find("login = ?1 AND senha = ?2", login, senha).singleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean delete(Long id) {
        try {
            //desfazer as relações antes de deletar
            getEntityManager().createNativeQuery(
                    "delete from cliente_endereco where id_endereco = " + id
            ).executeUpdate();
            getEntityManager().createNativeQuery(
                "delete from cliente_telefone where id_telefone = " + id
        ).executeUpdate();

            return deleteById(id);
        } catch (Exception e) {
            return false;
        }
    }
}