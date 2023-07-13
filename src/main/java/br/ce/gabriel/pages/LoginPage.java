package br.ce.gabriel.pages;

import br.ce.gabriel.core.BasePage;
import static br.ce.gabriel.core.DriverFactory.getDriver;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial() {
		getDriver().get("https://seubarriga.wcaquino.me/login");
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void entrar() {
		clicarBotaoPorTexto("Entrar");
	}
	
	public void resetar() {
		clicarLink("reset");
	}
}
