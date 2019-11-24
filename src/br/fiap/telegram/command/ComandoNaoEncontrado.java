package br.fiap.telegram.command;

import br.fiap.telegram.manager.BotManager;
import br.fiap.telegram.model.Cliente;

public class ComandoNaoEncontrado implements Comando{

    @Override
    public void processar(Cliente cliente) {
        BotManager.enviarMensagem( cliente.getChatId(), "Desculpe! n�o consegui entender. \nGostaria de pedir /ajuda?");
        ComandoStart.mostrarMenu(cliente);
    }
}
