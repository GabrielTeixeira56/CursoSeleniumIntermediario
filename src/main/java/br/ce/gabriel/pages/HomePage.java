package br.ce.gabriel.pages;

import br.ce.gabriel.core.BasePage;

public class HomePage extends BasePage{

	public String obterSaldoConta(String nome) {
		return obterCelula("Conta", nome, "Saldo", "tabelaContas").getText();
	}
	
	public void acessarTelaPrincipal() {
		clicarLink("Home");
	}
}
