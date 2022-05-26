package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWordSelenium {

	@Test
	public void hello() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_102.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:8080/leiloes");
		browser.quit();		
	}
	
}
