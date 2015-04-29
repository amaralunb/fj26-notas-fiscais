package br.com.caelum.notasfiscais.listener;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.util.EmailComercial;
import br.com.caelum.notasfiscais.util.EmailFinanceiro;

public class LoginListener {
	
	@Inject @EmailComercial
	private String email1;
	
	@Inject @EmailFinanceiro
	private String email2;
	
	public void onLogin (@Observes Usuario usuario) {
		System.out.printf("Usuario %s se logou no sistema. ", usuario.getLogin());
		System.out.printf("Enviando e-mail para %s", email1);
		System.out.printf("Enviando e-mail para %s", email2);
	}
}
