package br.com.caelum.ingresso.dao;

import br.com.caelum.ingresso.model.Terreno;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TerrenoDao {

	@PersistenceContext
	private EntityManager manager;

	public Terreno findOne(Integer id) {
		return manager.find(Terreno.class, id);
	}

	public void save(Terreno terreno) {
		manager.persist(terreno);
	}

	public List<Terreno> findAll() {
		return manager.createQuery("select t from Terreno t", Terreno.class).getResultList();
	}

	public void delete(Integer id) {
		manager.remove(findOne(id));
	}
}
