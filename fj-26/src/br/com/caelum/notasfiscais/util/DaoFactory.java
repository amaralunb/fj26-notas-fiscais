package br.com.caelum.notasfiscais.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import br.com.caelum.notasfiscais.dao.Dao;

public class DaoFactory implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Produces
	public Dao createDao(InjectionPoint injectionPoint) {
		ParameterizedType type = (ParameterizedType) injectionPoint.getType();
		Class classe = (Class) type.getActualTypeArguments()[0];
		
		return new Dao(classe);
	}
}
