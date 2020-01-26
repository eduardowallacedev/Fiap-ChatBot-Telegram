
package br.fiap.telegram.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cliente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 2790864233946864001L;

	private long chatId;
	private String comandoAtual;
	private String estadoAtual;
	private String mensagemAtual;
	private LocalDateTime lastUpdate;

	private Conta conta;

	public Cliente() {
	}

	public Cliente(String nome, long cpf, String rg, LocalDate dataNascimento) {
		super(nome, cpf, rg, dataNascimento);
	}

	public long getChatId() {
		return chatId;
	}

	public void setChatId(long chatId) {
		this.chatId = chatId;
	}

	public String getComandoAtual() {
		return comandoAtual;
	}

	public void setComandoAtual(String comandoAtual) {
		this.comandoAtual = comandoAtual;
	}

	public String getEstadoAtual() {
		return estadoAtual;
	}

	public void setEstadoAtual(String estadoAtual) {
		this.estadoAtual = estadoAtual;
	}

	public String getMensagemAtual() {
		return mensagemAtual;
	}

	public void setMensagemAtual(String mensagemAtual) {
		this.mensagemAtual = mensagemAtual;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Cliente [chatId=" + chatId + ", mensagemAtual=" + mensagemAtual + ", lastUpdate=" + lastUpdate + "]";
	}

}
