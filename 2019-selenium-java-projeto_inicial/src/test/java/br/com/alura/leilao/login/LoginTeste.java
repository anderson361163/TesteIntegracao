package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.lances.LancesPage;

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
		paginaDeLogin.preencherFormularioDeLogin("fulano", "pass");
		paginaDeLogin.efetuarLogin();
		
		Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
		Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
	}

	@Test
	public void naoDeveriaLogarComDadosInvalidos() {

		paginaDeLogin.preencherFormularioDeLogin("invalido", "123");
		paginaDeLogin.efetuarLogin();

		Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
		Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComDadosInvalidos());
		Assert.assertTrue(paginaDeLogin.isMensagemDeLoginInvalidoVisivel());
	}

	@Test
	public void naoDeveriaAcessarUrlRestritaSemEstarLogado() {
		
		paginaDeLogin.navegaParaPaginaDeLances();

		Assert.assertTrue(paginaDeLogin.isPaginaAtual());
		Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
	}

}
