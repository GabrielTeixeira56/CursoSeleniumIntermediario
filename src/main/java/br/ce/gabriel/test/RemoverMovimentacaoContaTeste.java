package br.ce.gabriel.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.gabriel.core.BaseTest;
import br.ce.gabriel.pages.ContasPage;
import br.ce.gabriel.pages.MenuPage;

public class RemoverMovimentacaoContaTeste extends BaseTest{
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testeExcluirContaComMovimentacao() {
		menuPage.acessarTelaListaConta();
		
		contasPage.clicaExcluirConta("Conta com movimentacao");
		Assert.assertEquals("Conta em uso na movimentações", 
				contasPage.obterMensagemErro());
	}
}
