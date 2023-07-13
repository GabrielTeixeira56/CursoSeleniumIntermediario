package br.ce.gabriel.core;

import static br.ce.gabriel.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.gabriel.pages.LoginPage;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	private static LoginPage loginPage = new LoginPage();
	
	@Before
	public void inicializa() {
		loginPage.acessarTelaInicial();
		loginPage.setEmail("gabriel@teixeira");
		loginPage.setSenha("123456");
		loginPage.entrar();
	}
	
	@After
	public void finaliza() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(
				"target/screenshot/" + testName.getMethodName() + ".jpg"));

		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}
