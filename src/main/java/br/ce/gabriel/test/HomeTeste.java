package br.ce.gabriel.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.gabriel.core.BaseTest;
import br.ce.gabriel.pages.HomePage;

public class HomeTeste extends BaseTest{
	HomePage homePage = new HomePage();
	//TODO resolver bug
	@Test
	public void testeSaldoConta() {
//		homePage.acessarTelaPrincipal();
		Assert.assertEquals("534.00", homePage.obterSaldoConta("Conta para saldo"));
	}
}
