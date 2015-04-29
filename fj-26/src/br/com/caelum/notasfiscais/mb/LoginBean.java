package br.com.caelum.notasfiscais.mb;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.Dao;
import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.tx.Transactional;

@Model
public class LoginBean {	
	private Usuario usuario = new Usuario();

	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	@Inject
	private UsuarioDao dao;
	
	@Inject
	private Dao<Usuario> usuarioDao;
	
	@Inject
	Event<Usuario> eventoLogin;
	
	public String efetuaLogin() {
		boolean loginValido = dao.existe(this.usuario);
		if(loginValido) {
			eventoLogin.fire(this.usuario);
			usuarioLogado.logar(usuario);
			return "produto?faces-redirect=true";
		} else {
			this.usuario = new Usuario();
			return "login";
		}
	}

	@Transactional
	public String cadastrarUsuario() {
		usuarioDao.adiciona(usuario);
		return "login?faces-redirect=true";
	
	}
	
	public String logout() {
		usuarioLogado.deslogar();
		return "login?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
}
