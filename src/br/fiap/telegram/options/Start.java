package br.fiap.telegram.options;

import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;

import br.fiap.telegram.manager.BotManager;
import br.fiap.telegram.model.Cliente;

public class Start implements Opcoes{


    @Override
    public void processar(Cliente cliente) {

        String msg = "Bem vindo ao Wallace Bank.\n";

        BotManager.enviarMensagem(cliente.getChatId(), msg);
        mostrarMenu(cliente);

    }


    /**
     * Menu de opções
     */
    static void mostrarMenu(Cliente cliente) {

        Keyboard keyboard = new ReplyKeyboardMarkup(

                new String[]{ Enum.ABRIR_CONTA.codigo, Enum.MODIFICAR_CONTA.codigo },
                new String[]{ Enum.DEPOSITO.codigo, Enum.SAQUE.codigo },
                new String[]{ Enum.EXTRATO.codigo, Enum.LANCAMENTOS.codigo},                
                new String[]{ Enum.RETIRADAS.codigo, Enum.TARIFAS.codigo },
                new String[]{ Enum.AJUDA.codigo });

        BotManager.enviarMensagem(cliente.getChatId(), "Em que podemos ajudá-lo(a) agora?", keyboard);
    }
}
