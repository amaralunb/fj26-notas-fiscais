package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean {
	private Produto produto = new Produto();
	private List<Produto> produtos;

	public Produto getProduto() {
		return this.produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		if (produtos == null) {
			System.out.println("Carregando produtos...");
			produtos = new ProdutoDao().listaTodos();
		}
		return this.produtos;
	}
	
	public String adicionar () {
		System.out.println("Será que passa por aqui?");
		ProdutoDao dao = new ProdutoDao();
		if(produto.getId() == null)
			dao.adiciona(produto);
		else
			dao.atualiza(produto);
		
		this.produtos = dao.listaTodos();
		this.produto = new Produto();
		
		return "produto?faces-redirect=true";
	}
	
	public void remover (Produto produto) {
		ProdutoDao dao = new ProdutoDao();
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}
	
	public void cancelar () {
		this.produto = new Produto();
	}
	
}
