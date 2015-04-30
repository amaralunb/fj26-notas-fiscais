package br.com.caelum.notasfiscais.mb;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.Dao;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.stereotypes.ViewModel;

@ViewModel
public class ListaNotasFiscaisBean {
	private List<NotaFiscal> nfLista = new ArrayList<NotaFiscal>();
	
	@Inject
	private Dao<NotaFiscal> nfDao;
	
	public List<NotaFiscal> getNfLista() {
		if(nfLista == null) {
			this.nfLista = nfDao.listaTodos();
		}
		return nfLista;
	}

	public void setNfLista(List<NotaFiscal> nfLista) {
		this.nfLista = nfLista;
	}
	
}
