package br.ce.gabriel.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.gabriel.core.BaseTest;
import br.ce.gabriel.core.Propriedades;
import br.ce.gabriel.pages.MenuPage;
import br.ce.gabriel.pages.MovimentacaoPage;
import static br.ce.gabriel.utils.DataUtils.obterDataFormatada;
import static br.ce.gabriel.utils.DataUtils.obterDataComDiferencaDias;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTeste extends BaseTest {
	MenuPage menuPage = new MenuPage();
	MovimentacaoPage movPage = new MovimentacaoPage();

	@Test
	public void teste2InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Movimentação de teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();

		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
	}

	@Test
	public void teste3CamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		movPage.salvar();

		List<String> erros = movPage.obterMensagemErro();

//		Assert.assertTrue(erros.contains("Data Movimentação é obrigatório"));
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório", "Descrição é obrigatório", "Interessado é obrigatório",
				"Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
	}

	@Test
	public void teste3InserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();

		Date dataFutura = obterDataComDiferencaDias(5);

		movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movPage.setDataPagamento(obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimentação de teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();

		List<String> erros = movPage.obterMensagemErro();
		Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals(1, erros.size());
	}
}
