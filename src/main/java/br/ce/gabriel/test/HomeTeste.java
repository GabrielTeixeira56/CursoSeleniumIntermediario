package br.ce.gabriel.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.gabriel.core.BaseTest;
import br.ce.gabriel.core.Propriedades;
import br.ce.gabriel.pages.HomePage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomeTeste extends BaseTest{
	HomePage homePage = new HomePage();
	//TODO resolver bug
	@Test
	public void testeSaldoConta() {
		homePage.acessarTelaPrincipal();
		Assert.assertEquals("500.00", homePage.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
	}
}
