package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.alura.leilao.lances.CadastroLeilaoPage;

public class LeiloesPage {

	private static final String URL_CADASTRO_LEILOES = "http://localhost:8080/leiloes/new";
	private WebDriver browser;
	
	public LeiloesPage(WebDriver browser) {
		this.browser = browser;
	}

	public void fechar() {
		this.browser.quit();
	}

	public CadastroLeilaoPage carregarFormulario() {
		this.browser.navigate().to(URL_CADASTRO_LEILOES);
		return new CadastroLeilaoPage(browser);
	}

	public boolean isLeilaoCadastrado(String nome, String valor, String data) {
		WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		
		WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		
		return colunaNome.getText().equals(nome)
				&& colunaDataAbertura.getText().equals(data)
				&& colunaValorInicial.getText().equals(valor);
	}

}
