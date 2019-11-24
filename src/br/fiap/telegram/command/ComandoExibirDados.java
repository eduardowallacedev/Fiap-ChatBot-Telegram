
package br.fiap.telegram.command;

import br.fiap.telegram.manager.BotManager;
import br.fiap.telegram.manager.SessionManager;
import br.fiap.telegram.model.Cliente;

public class ComandoExibirDados implements Comando {

	@Override
	public void processar(Cliente cliente) throws Exception {

		if (!clientePossuiConta(cliente)) {
			BotManager.enviarMensagem(cliente.getChatId(),
					"Você não possui conta cadastrada!" + "\nCrie uma conta antes de continuar. /abrirconta");
			cliente.setComandoAtual(null);
			SessionManager.addClient(cliente);
			SessionManager.addClient(cliente);
			ComandoStart.mostrarMenu(cliente);
			return;
		}

		exibirDados(cliente);

	}

	private boolean clientePossuiConta(Cliente cliente) {
		return cliente.getConta() != null;
	}

	private void exibirDados(Cliente cliente) throws Exception {

		StringBuilder msg = new StringBuilder();

		msg.append("Ag: " + cliente.getConta().getNumAg() + "\nCc: " + cliente.getConta().getNumCc()
				+ "\nSaldo atual: R$ " + cliente.getConta().getSaldo());

		msg.append("\n\nInformações do Titular:" + "\nNome: " + cliente.getNome() + "\nCPF: " + cliente.getCpf()
				+ "\nRG: " + cliente.getRg() + "\nData Nascimento: " + cliente.getDataNascFormat());

		cliente.setMensagemAtual(null);
		cliente.setEstadoAtual(null);
		cliente.setComandoAtual(null);

		SessionManager.addClient(cliente);

		BotManager.enviarMensagem(cliente.getChatId(), msg.toString());
		ComandoStart.mostrarMenu(cliente);

	}
}
