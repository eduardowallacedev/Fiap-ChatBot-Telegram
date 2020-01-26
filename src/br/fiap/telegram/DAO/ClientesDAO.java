package br.fiap.telegram.DAO;

import java.io.Serializable;
import java.util.Date;

import org.prevayler.Transaction;

import br.fiap.telegram.model.Cliente;
import br.fiap.telegram.utils.ListaCliente;

public class ClientesDAO implements Transaction<ListaCliente>, Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;

	public ClientesDAO(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public void executeOn(ListaCliente lista, Date data) {
		lista.adicionar(cliente);
	}

}