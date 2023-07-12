package br.ce.gabriel.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.gabriel.core.BaseTest;
import br.ce.gabriel.core.Propriedades;
import br.ce.gabriel.pages.ContasPage;
import br.ce.gabriel.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RemoverMovimentacaoContaTeste extends BaseTest{
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testeExcluirContaComMovimentacao() {
		menuPage.acessarTelaListaConta();
		
		contasPage.clicaExcluirConta(Propriedades.NOME_CONTA_ALTERADA);
		Assert.assertEquals("Conta em uso na movimentações", 
				contasPage.obterMensagemErro());
	}
}
