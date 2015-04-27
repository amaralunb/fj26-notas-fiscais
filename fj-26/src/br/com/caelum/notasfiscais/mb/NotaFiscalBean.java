package br.com.caelum.notasfiscais.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@Named
@RequestScoped
public class NotaFiscalBean {
	private NotaFiscal notaFiscal = new NotaFiscal();
	
	@Inject
	private NotaFiscalDao nfDao;

	public void gravar() {
		this.nfDao.adiciona(notaFiscal);
		
		this.notaFiscal = new NotaFiscal();
	}
	
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
}
