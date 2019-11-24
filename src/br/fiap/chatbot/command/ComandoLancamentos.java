
package br.fiap.chatbot.command;

import java.util.List;
import java.util.stream.Collectors;

import br.fiap.chatbot.manager.BotManager;
import br.fiap.chatbot.manager.SessionManager;
import br.fiap.chatbot.model.Cliente;
import br.fiap.chatbot.model.Lancamento;

public class ComandoLancamentos implements Comando {

	@Override
	public void processar(Cliente cliente) throws Exception {

		if (!clientePossuiConta(cliente)) {
			BotManager.enviarMensagem(cliente.getChatId(),
			        "Voc� n�o possui conta cadastrada!" + "\nCrie uma conta antes de continuar. /abrirconta");
			cliente.setComandoAtual(null);

			SessionManager.addClient(cliente);

			ComandoStart.mostrarMenu(cliente);
			return;
		}

		lancamentos(cliente);

	}

	private boolean clientePossuiConta(Cliente cliente) {
		return cliente.getConta() != null;
	}

	private void lancamentos(Cliente cliente) throws Exception {

		List<Lancamento> lancamentos = cliente.getConta().getLancamentos();

		if (lancamentos != null && !lancamentos.isEmpty()) {

			double somaDepositos = 0f;
			double somaSaques = 0f;

			int totalDepositos = 0;
			int totalSaques = 0;

			StringBuilder sb = new StringBuilder();

			sb.append("Resumo de lan�amentos");
			sb.append("\n");
			sb.append("\n");
			sb.append("Total de lan�amentos: " + lancamentos.size());
			sb.append("\n");

			List<Lancamento> lancamentosSaque =
			        lancamentos.stream().filter(o -> o.getDescricao().startsWith("Saque")).collect(Collectors.toList());

			List<Lancamento> lancamentosDeposito =
			        lancamentos.stream().filter(o -> o.getDescricao().startsWith("Dep�sito")).collect(
			                Collectors.toList());

			List<Lancamento> lancamentosExtrato =
			        lancamentos.stream().filter(o -> o.getDescricao().startsWith("Extrato")).collect(
			                Collectors.toList());

			for (Lancamento lc : lancamentosSaque) {
				somaSaques += lc.getValor();
				totalSaques++;
			}

			for (Lancamento lc : lancamentosDeposito) {
				somaDepositos += lc.getValor();
				totalDepositos++;
			}


			sb.append("\nValor Depositado: R$ " + somaDepositos);
			sb.append("\nValor Sacado: R$ " + somaSaques);
			sb.append("\n\nTotal de Dep�sito: " + totalDepositos);
			sb.append("\nTotal de Saques: " + totalSaques);
			sb.append("\nTotal de Extratos: " + lancamentosExtrato.size());

			BotManager.enviarMensagem(cliente.getChatId(), sb.toString());

		} else {
			BotManager.enviarMensagem(cliente.getChatId(), "Voc� n�o possui possui lan�amentos!");
		}

		cliente.setMensagemAtual(null);
		cliente.setEstadoAtual(null);
		cliente.setComandoAtual(null);

		SessionManager.addClient(cliente);

		ComandoStart.mostrarMenu(cliente);

	}
}
