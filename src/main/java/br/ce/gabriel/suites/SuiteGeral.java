package br.ce.gabriel.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

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
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		page.setEmail("gabriel@teixeira");
		page.setSenha("123456");
		page.entrar();
		page.resetar();
	}
}
