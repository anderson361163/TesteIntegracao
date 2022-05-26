package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTeste {

	private LoginPage paginaDeLogin;

	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}
	
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		paginaDeLogin.prencheFormularioDeLogin("fulano", "pass");
		paginaDeLogin.efetuarLogin();
		
		Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
		Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());

	}

	@Test
	public void naoDeveriaLogarComDadosInvalidos() {

		paginaDeLogin.prencheFormularioDeLogin("invalido", "123");
		paginaDeLogin.efetuarLogin();

		Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComDadosInvalidos());
		Assert.assertNull("fulano", paginaDeLogin.getNomeUsuarioLogado());

	}

	@Test
	public void naoDeveriaEstarAcessarPaginaRestritaSemEstarLogado() {
		paginaDeLogin.navegaParaPaginaDeLances();

		Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
		Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));

	}

}
