package br.com.caelum.notasfiscais.mb;

import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.Dao;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.stereotypes.ViewModel;
import br.com.caelum.notasfiscais.tx.Transactional;
import br.com.caelum.notasfiscais.util.EmailFinanceiro;

@ViewModel
public class NotaFiscalBean {
	private NotaFiscal notaFiscal = new NotaFiscal();
	private Item item = new Item();
	private Long idProduto;
	
	@Inject @EmailFinanceiro
	private String email;
	
	@Inject
	private Dao<Produto> produtoDao;
	
	@Inject
	private Dao<NotaFiscal> nfDao;

	@Transactional
	public void gravar() {
		this.nfDao.adiciona(notaFiscal);
		
		this.notaFiscal = new NotaFiscal();
	}
	
	public void guardaItem() {
		Produto produto = produtoDao.buscaPorId(idProduto);
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());
		
		notaFiscal.getItens().add(item);
		item.setNotaFiscal(notaFiscal);
		
		item = new Item();
	}
	
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
}
