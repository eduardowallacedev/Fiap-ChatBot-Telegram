package br.fiap.chatbot.command;

import br.fiap.chatbot.manager.BotManager;
import br.fiap.chatbot.model.Cliente;

public class ComandoNaoEncontrado implements Comando{

    @Override
    public void processar(Cliente cliente) {
        BotManager.enviarMensagem( cliente.getChatId(), "Desculpe! n�o consegui entender. \nGostaria de pedir /ajuda?");
        ComandoStart.mostrarMenu(cliente);
    }
}
