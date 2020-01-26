package br.fiap.telegram.options;

import br.fiap.telegram.manager.BotManager;
import br.fiap.telegram.manager.SessionManager;
import br.fiap.telegram.model.Cliente;

public class Saque implements Opcoes {


    @Override
    public void processar(Cliente cliente) throws Exception {

        if (!clientePossuiConta(cliente)) {
            BotManager.enviarMensagem(cliente.getChatId(), "Você não possui conta cadastrada!" +
                    "\nCrie uma conta antes de continuar. /abrirconta");
            cliente.setComandoAtual(null);
            
            SessionManager.addClient(cliente);
            
            Start.mostrarMenu(cliente);
            return;
        }

        boolean isComando = Enum.getByCodigo(cliente.getMensagemAtual()) != null;

        if (cliente.getEstadoAtual() == null || "".equals(cliente.getEstadoAtual()) || isComando) {
            cliente.setMensagemAtual("");
            cliente.setEstadoAtual("informar_valor");
            SessionManager.addClient(cliente);
        }

        sacar(cliente);

    }

    private boolean clientePossuiConta(Cliente cliente) {
        return cliente.getConta() != null;
    }


    private void sacar(Cliente cliente) {

        if (cliente.getMensagemAtual().trim().equals("")) {
            BotManager.enviarMensagem(cliente.getChatId(), "Informe o valor a ser sacado (será cobrada uma taxa)");
            return;
        }

        try {
            Double valor = Double.parseDouble(cliente.getMensagemAtual());

            if(cliente.getConta().sacar(valor)){
                BotManager.enviarMensagem(cliente.getChatId(), "Saque efetuado com sucesso! :)\nSaldo atual: R$ " + cliente.getConta().getSaldo());
            }else{
                BotManager.enviarMensagem(cliente.getChatId(), "Saldo insuficiente para o saque! :(\nSaldo atual: R$ " + cliente.getConta().getSaldo());
            }

            cliente.setMensagemAtual(null);
            cliente.setEstadoAtual(null);
            cliente.setComandoAtual(null);
            
            SessionManager.addClient(cliente);

            Start.mostrarMenu(cliente);

        } catch (Exception e) {
            BotManager.enviarMensagem(cliente.getChatId(), "Valor inválido! Tente novamente!");
        }
    }
}
