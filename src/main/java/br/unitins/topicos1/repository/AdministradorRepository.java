package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Administrador;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;

import java.util.List;

@ApplicationScoped
public class AdministradorRepository implements PanacheRepository<Administrador> {
    public List<Administrador> findByName(String nome) {
        return find("LOWER(nome) LIKE LOWER(?1)", "%" + nome + "%").list();
    }

 public Administrador findByLogin(String login) {
        try {
            return find("login = ?1", login ).singleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Administrador findByLoginAndSenha(String login, String senha) {
        try {
            return find("login = ?1 AND senha = ?2", login, senha).singleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
        
    }

}


