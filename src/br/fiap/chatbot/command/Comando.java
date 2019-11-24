package br.fiap.chatbot.command;

import br.fiap.chatbot.model.Cliente;

public interface Comando {

    void processar(Cliente cliente) throws Exception;
}
