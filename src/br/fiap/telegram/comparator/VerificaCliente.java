
package br.fiap.telegram.comparator;

import java.util.Comparator;

import br.fiap.telegram.model.Cliente;

public class VerificaCliente implements Comparator<Cliente> {
	public int compare(Cliente cliente, Cliente outroCliente) {
		return cliente.getLastUpdate().compareTo(outroCliente.getLastUpdate());
	}
}
