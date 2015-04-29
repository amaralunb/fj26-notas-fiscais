package br.com.caelum.notasfiscais.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class Dao<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private final Class<T> classe;

	//@Inject
	private EntityManager manager;
	
	public Dao(Class<T> classe, EntityManager manager) {
		this.classe = classe;
		this.manager = manager;
	}

	public void adiciona(T t) {
		manager.persist(t);
	}

	public void remove(T t) {
		manager.remove(manager.merge(t));
	}

	public void atualiza(T t) {
		manager.merge(t);
	}

	public List<T> listaTodos() {
		CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = manager.createQuery(query).getResultList();

		return lista;
	}

	public T buscaPorId(Long id) {
		T instancia = manager.find(classe, id);
		return instancia;
	}

	public int contaTodos() {
		long result = (Long) manager.createQuery(
				"select count(n) from " + classe.getName() + " n")
				.getSingleResult();

		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = manager.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();
		return lista;
	}

}
