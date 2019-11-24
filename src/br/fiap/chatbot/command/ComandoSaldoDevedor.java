package br.fiap.chatbot.command;

import br.fiap.chatbot.manager.BotManager;
import br.fiap.chatbot.manager.SessionManager;
import br.fiap.chatbot.model.Cliente;
import br.fiap.chatbot.model.Emprestimo;

public class ComandoSaldoDevedor implements Comando {


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


        saldoDevedor(cliente);

    }

    private boolean clientePossuiConta(Cliente cliente) {
        return cliente.getConta() != null;
    }


    private void saldoDevedor(Cliente cliente) throws Exception {

        if (cliente.getConta().getEmprestimos() != null && !cliente.getConta().getEmprestimos().isEmpty()) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < cliente.getConta().getEmprestimos().size(); i++) {

                Emprestimo emprestimo = cliente.getConta().getEmprestimos().get(i);

                sb.append("\nEmpr�stimo " + (i + 1) +
                        "\nValor Contratado: R$ " + emprestimo.getValorContratado() +
                        "\nData Contrata��o: " + emprestimo.getDataContratacaoFormated() +
                        "\nQuantidade de Meses: " + emprestimo.getQtdeMeses() +
                        "\nValor Total do Empr�stimo: R$ " + emprestimo.getValorEmprestimo() +
                        "\nData Final do Empr�stimo: R$ " + emprestimo.getDataFinalEmprestimo()+"\n");

            }

            BotManager.enviarMensagem(cliente.getChatId(), sb.toString());

        } else {
            BotManager.enviarMensagem(cliente.getChatId(), "Voc� n�o possui saldo devedor!");
        }


        cliente.setMensagemAtual(null);
        cliente.setEstadoAtual(null);
        cliente.setComandoAtual(null);
        
        SessionManager.addClient(cliente);

        ComandoStart.mostrarMenu(cliente);

    }
}
