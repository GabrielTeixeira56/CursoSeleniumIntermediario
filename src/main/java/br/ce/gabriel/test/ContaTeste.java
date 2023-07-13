package br.ce.gabriel.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.gabriel.core.BaseTest;
import br.ce.gabriel.pages.ContasPage;
import br.ce.gabriel.pages.MenuPage;

public class ContaTeste extends BaseTest {
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void teste1_InserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta do Teste");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void teste2_AlterarConta() {
		menuPage.acessarTelaListaConta();
		contasPage.clicaAlterarConta("Conta do teste"); 
		contasPage.setNome("Conta alterada");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void teste3_InserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta mesmo nome");
		contasPage.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}
	
	
}
