package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean {
	private Produto produto = new Produto();

	public Produto getProduto() {
		return this.produto;
	}
	
	public void adiciona () {
		ProdutoDao dao = new ProdutoDao();
		dao.adiciona(produto);
	}
	
}
