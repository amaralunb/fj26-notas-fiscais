package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.tx.Transactional;

@ManagedBean
public class ProdutoBean {
	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	@Inject 
	private ProdutoDao produtoDao; 

	public Produto getProduto() {
		return this.produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		if (produtos == null) {
			System.out.println("Carregando produtos...");
			produtos = produtoDao.listaTodos();
		}
		return this.produtos;
	}
	
	@Transactional
	public String adicionar () {
		//System.out.println("Será que passa por aqui?");
		if(produto.getId() == null)
			produtoDao.adiciona(produto);
		else
			produtoDao.atualiza(produto);
		
		this.produtos = produtoDao.listaTodos();
		this.produto = new Produto();
		
		return "produto?faces-redirect=true";
	}
	
	public void remover (Produto produto) {
		produtoDao.remove(produto);
		this.produtos = produtoDao.listaTodos();
	}
	
	public void cancelar () {
		this.produto = new Produto();
	}
	
}
