package br.fiap.telegram.options;

import br.fiap.telegram.manager.BotManager;
import br.fiap.telegram.model.Cliente;

public class NaoEncontrado implements Opcoes{

    @Override
    public void processar(Cliente cliente) {
        BotManager.enviarMensagem( cliente.getChatId(), "Por gentileza escolher uma das opções abaixo. /ajuda");
        Start.mostrarMenu(cliente);
    }
}
