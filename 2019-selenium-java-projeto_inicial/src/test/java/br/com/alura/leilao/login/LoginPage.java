package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.alura.leilao.leiloes.LeiloesPage;

public class LoginPage {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;
	
	public LoginPage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_102.exe");
		this.browser = new ChromeDriver();
		browser.navigate().to(URL_LOGIN);
	}

	public void fechar() {
		this.browser.quit();
	}

	public void preencherFormularioDeLogin(String username, String senha) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(senha);
	}
	
	public LeiloesPage efetuarLogin() {
		browser.findElement(By.id("login-form")).submit();
		return new LeiloesPage(browser);
	}

	public boolean isPaginaAtual() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}
	
	
	public boolean isPaginaDeLogin() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public boolean isPaginaDeLoginComDadosInvalidos() {
		return browser.getCurrentUrl().equals(URL_LOGIN + "?error");
	}
	
	public String getNomeUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText();
		}catch(NoSuchElementException e) {
			return null;
		}
	}

	public void navegaParaPaginaDeLances() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");
	}
	
	public boolean isMensagemDeLoginInvalidoVisivel() {
		return browser.getPageSource().contains("Usuário e senha inválidos.");
	}

	public boolean contemTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}
	
	
}
