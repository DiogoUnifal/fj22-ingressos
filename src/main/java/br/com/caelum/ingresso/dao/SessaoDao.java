package br.com.caelum.ingresso.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class SessaoDao {
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Sessao sessao) {
		manager.persist(sessao);
	}
}
