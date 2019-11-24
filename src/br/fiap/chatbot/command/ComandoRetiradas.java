
package br.fiap.chatbot.command;

import java.util.List;

import br.fiap.chatbot.manager.BotManager;
import br.fiap.chatbot.manager.SessionManager;
import br.fiap.chatbot.model.Cliente;
import br.fiap.chatbot.model.Lancamento;

public class ComandoRetiradas implements Comando {

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

		retiradas(cliente);

	}

	private boolean clientePossuiConta(Cliente cliente) {
		return cliente.getConta() != null;
	}

	private void retiradas(Cliente cliente) throws Exception {

		List<Lancamento> retiradas = cliente.getConta().retiradas();

		if (retiradas != null && !retiradas.isEmpty()) {

			double somaRetiradas = 0f;
			StringBuilder sb = new StringBuilder();

			for (Lancamento lc : retiradas) {

				sb.append(lc.getExtrato());
				sb.append("\n");

				somaRetiradas += lc.getValor();
			}

			sb.append("\nTotal Retiradas: R$ " + somaRetiradas);

			BotManager.enviarMensagem(cliente.getChatId(), sb.toString());

		} else {
			BotManager.enviarMensagem(cliente.getChatId(), "Voc� n�o possui retiradas!");
		}

		cliente.setMensagemAtual(null);
		cliente.setEstadoAtual(null);
		cliente.setComandoAtual(null);

		SessionManager.addClient(cliente);

		ComandoStart.mostrarMenu(cliente);

	}
}
