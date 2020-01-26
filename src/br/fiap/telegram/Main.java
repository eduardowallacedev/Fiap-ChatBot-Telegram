package br.fiap.telegram;

import br.fiap.telegram.bot.Bot;


/**
 * Executa a aplicação 
 *
 */

public class Main {

	public static void main(String ...args) {
		Bot bot = new Bot();
		bot.run();
	}
}
