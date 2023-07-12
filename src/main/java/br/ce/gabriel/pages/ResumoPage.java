package br.ce.gabriel.pages;

import org.openqa.selenium.By;

import br.ce.gabriel.core.BasePage;

public class ResumoPage extends BasePage{
	
	public void excluirMovimentacao() {
		clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
}
