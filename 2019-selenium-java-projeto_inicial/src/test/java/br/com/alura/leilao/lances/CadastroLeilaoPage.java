package br.com.alura.leilao.lances;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.leiloes.LeiloesPage;

public class CadastroLeilaoPage {
	
	private WebDriver browser;
	
	public CadastroLeilaoPage(WebDriver browser) {
		this.browser = browser;
	}
	
	public void fechar() {
		this.browser.quit();
	}

	public LeiloesPage cadastrarLeilao(String nome, String valor, String hoje) {
		this.browser.findElement(By.id("nome")).sendKeys(nome);
		this.browser.findElement(By.id("valorInicial")).sendKeys(valor);
		this.browser.findElement(By.id("dataAbertura")).sendKeys(hoje);
		this.browser.findElement(By.id("button-submit")).submit();
		return new LeiloesPage(browser);
	}
	
	
}
