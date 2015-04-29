package br.com.caelum.notasfiscais.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class NotaFiscalDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public int contaTodos() {
		long result = (Long) manager.createQuery("select count(n) from NotaFiscal n").getSingleResult();
		
		return (int) result;
	}

}
