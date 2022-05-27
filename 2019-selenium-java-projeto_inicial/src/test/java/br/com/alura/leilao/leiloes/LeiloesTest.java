package br.com.alura.leilao.leiloes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.lances.CadastroLeilaoPage;
import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;
	
	//não cria nada porque não tem
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLeiloes.fechar();
	}
	
	@Test
	public void deveriaCadastrarLeilao() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencherFormularioDeLogin("fulano", "pass");
		this.paginaDeLeiloes = paginaDeLogin.efetuarLogin();
		CadastroLeilaoPage paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
		
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilao do dia "+hoje;
		String valor = "500.00";

		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
		Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
	}
}
