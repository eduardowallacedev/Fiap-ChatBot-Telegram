package br.fiap.telegram.manager;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.DeleteMessage;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

import br.fiap.telegram.config.BotConfig;

public class BotManager {

	private static TelegramBot bot;
	private static final Logger LOGGER = Logger.getGlobal();

	public static TelegramBot getBotInstance() {

		if (bot == null) {
			bot = new TelegramBot(BotConfig.BOT_TOKEN);
		}

		return bot;
	}

	public static void enviarMensagem(long chatId, String mensagem) {
		enviarMensagem(chatId, mensagem, new ForceReply());
	}

	public static void enviarMensagem(long chatId, String mensagem, Keyboard keyboard) {

		SendResponse sr = BotManager.getBotInstance().execute(new SendMessage(chatId, mensagem)
				.parseMode(ParseMode.HTML).disableWebPagePreview(true).disableNotification(true).replyMarkup(keyboard));

		if (!sr.isOk()) {
			LOGGER.log(Level.SEVERE, "Falha ao enviar mensagem");
			LOGGER.log(Level.SEVERE, sr.description() + " (" + sr.errorCode() + ")");
			LOGGER.log(Level.SEVERE, "Chat Id: " + chatId);
		}
	}

	/**
	 * Apaga a Mensagem
	 *
	 * @param chatId
	 * @param mensagemId
	 */
	public static void deletarMensagem(int chatId, int mensagemId) {

		BaseResponse br = bot.execute(new DeleteMessage(chatId, mensagemId));

		if (!br.isOk()) {
			LOGGER.log(Level.SEVERE, "Falha ao enviar mensagem");
			LOGGER.log(Level.SEVERE, br.description() + " (" + br.errorCode() + ")");
			LOGGER.log(Level.SEVERE, "Chat Id: " + chatId);
		}
	}
}
