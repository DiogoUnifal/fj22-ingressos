package br.com.caelum.ingresso.dao;

import br.com.caelum.ingresso.model.Quadra;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class QuadraDao {
	@PersistenceContext
  private EntityManager manager;
	
	public Quadra findOne(Integer id) {
		return manager.find(Quadra.class, id);
	}
	
	public void save(Quadra quadra) {
		manager.persist(quadra);
	}
	
	public List<Quadra> findAll() {
		return manager.createQuery("SELECT q FROM Quadra q", Quadra.class).getResultList();
	}
	
	public void delete(Integer id) {
		manager.remove(findOne(id));
	}

}
