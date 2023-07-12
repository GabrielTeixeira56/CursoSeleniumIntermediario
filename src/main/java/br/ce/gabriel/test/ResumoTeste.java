package br.ce.gabriel.test;

import static br.ce.gabriel.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.gabriel.core.BaseTest;
import br.ce.gabriel.pages.MenuPage;
import br.ce.gabriel.pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTeste extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resPage = new ResumoPage();

	@Test
	public void teste1ExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		resPage.excluirMovimentacao();

		Assert.assertEquals("Movimentação removida com sucesso!", resPage.obterMensagemSucesso());
	}

	@Test
	// @Test(expected=NoSuchElementException.class)
	public void teste2ResumoMensal() {
		menuPage.acessarTelaResumo();

		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());

//		try {
//			getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
//			Assert.fail();
//		} catch (NoSuchElementException e) {}
		
		List<WebElement> elementosEncontrados 
			= getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		
		Assert.assertEquals(0, elementosEncontrados.size());
	}
}
