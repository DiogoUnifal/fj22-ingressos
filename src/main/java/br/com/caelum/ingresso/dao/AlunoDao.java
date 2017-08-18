package br.com.caelum.ingresso.dao;

import br.com.caelum.ingresso.model.Aluno;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by nando on 03/03/17.
 */
@Repository
public class AlunoDao {

    @PersistenceContext
    private EntityManager manager;


    public Aluno findOne(Integer id) {
        return manager.find(Aluno.class, id);
    }

    public void save(Aluno aluno) {
        manager.persist(aluno);
    }

    public List<Aluno> findAll() {
        return manager.createQuery("select a from Aluno a", Aluno.class).getResultList();
    }

    public void delete(Integer id) {
        manager.remove(findOne(id));
    }
}
