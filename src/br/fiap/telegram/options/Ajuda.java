package br.fiap.telegram.options;

import br.fiap.telegram.manager.BotManager;
import br.fiap.telegram.manager.SessionManager;
import br.fiap.telegram.model.Cliente;

public class Ajuda implements Opcoes {

	@Override
	public void processar(Cliente cliente) throws Exception {
		ajuda(cliente);
	}

	private void ajuda(Cliente cliente) throws Exception {

		StringBuilder sb = new StringBuilder();

		for (Enum comandoEnum : Enum.values()) {

			sb.append(comandoEnum.codigo + " - " + comandoEnum.descricao);
			sb.append("\n");

		}

		BotManager.enviarMensagem(cliente.getChatId(), sb.toString());

		cliente.setMensagemAtual(null);
		cliente.setEstadoAtual(null);
		cliente.setComandoAtual(null);

		SessionManager.addClient(cliente);

		Start.mostrarMenu(cliente);

	}
}
