package br.fiap.chatbot.command;

import br.fiap.chatbot.manager.BotManager;
import br.fiap.chatbot.manager.SessionManager;
import br.fiap.chatbot.model.Cliente;

public class ComandoDeposito implements Comando {


    @Override
    public void processar(Cliente cliente) throws Exception {

        if (!clientePossuiConta(cliente)) {
            BotManager.enviarMensagem(cliente.getChatId(), "Voc� n�o possui conta cadastrada!" +
                    "\nCrie uma conta antes de continuar. /abrirconta");
            cliente.setComandoAtual(null);
            SessionManager.addClient(cliente);
            ComandoStart.mostrarMenu(cliente);
            return;
        }

        boolean isComando = ComandoEnum.getByCodigo(cliente.getMensagemAtual()) != null;

        if (cliente.getEstadoAtual() == null || "".equals(cliente.getEstadoAtual()) || isComando) {
            cliente.setMensagemAtual("");
            cliente.setEstadoAtual("informar_valor");
            SessionManager.addClient(cliente);
        }

        depositar(cliente);

    }

    private boolean clientePossuiConta(Cliente cliente) {
        return cliente.getConta() != null;
    }


    private void depositar(Cliente cliente) {

        if (cliente.getMensagemAtual().trim().equals("")) {
            BotManager.enviarMensagem(cliente.getChatId(), "Informe o valor a ser depositado");
            return;
        }

        try {
            Double valor = Double.parseDouble(cliente.getMensagemAtual());
            cliente.getConta().depositar(valor);
            cliente.setMensagemAtual(null);
            cliente.setEstadoAtual(null);
            cliente.setComandoAtual(null);
            
            SessionManager.addClient(cliente);

            BotManager.enviarMensagem(cliente.getChatId(), "Dep�sito efetuado com sucesso! :)\nSaldo atual: R$ " + cliente.getConta().getSaldo());
            ComandoStart.mostrarMenu(cliente);

        } catch (Exception e) {
            BotManager.enviarMensagem(cliente.getChatId(), "Valor inv�lido! Tente novamente!");
        }
    }
}
