package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.Dao;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.stereotypes.ViewModel;

@ViewModel
public class ListaNotasFiscaisBean {
	private List<NotaFiscal> notas;
	
	@Inject
	private Dao<NotaFiscal> notaFiscalDao;
	
	public List<NotaFiscal> getNotas() {
		if(notas == null) {
			notas = notaFiscalDao.listaTodos();
		}
		return this.notas;
	}
	
	public void setNotas(List<NotaFiscal> notas) {
		this.notas = notas;
	}
	
}
