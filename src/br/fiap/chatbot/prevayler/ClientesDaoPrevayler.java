package br.fiap.chatbot.prevayler;

import java.io.Serializable;
import java.util.Date;

import org.prevayler.Transaction;

import br.fiap.chatbot.model.Cliente;
import br.fiap.chatbot.utils.ListaCliente;

public class ClientesDaoPrevayler implements Transaction<ListaCliente>, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;

	public ClientesDaoPrevayler(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public void executeOn(ListaCliente lista, Date data) {
		lista.adicionar(cliente);
	}

	

}