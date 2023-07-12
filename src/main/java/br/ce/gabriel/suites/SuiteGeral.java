package br.ce.gabriel.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.gabriel.core.DriverFactory;
import br.ce.gabriel.pages.LoginPage;
import br.ce.gabriel.test.ContaTeste;
import br.ce.gabriel.test.HomeTeste;
import br.ce.gabriel.test.MovimentacaoTeste;
import br.ce.gabriel.test.RemoverMovimentacaoContaTeste;
import br.ce.gabriel.test.ResumoTeste;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTeste.class,
	MovimentacaoTeste.class,
	RemoverMovimentacaoContaTeste.class,
	HomeTeste.class,
	ResumoTeste.class
})
public class SuiteGeral {
	private static LoginPage loginPage = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {
		loginPage.acessarTelaInicial();
		loginPage.setEmail("gabriel@teixeira");
		loginPage.setSenha("123456");
		loginPage.entrar();
	}
	
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}
}
