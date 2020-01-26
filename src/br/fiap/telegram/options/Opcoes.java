package br.fiap.telegram.options;

import br.fiap.telegram.model.Cliente;

public interface Opcoes {

    void processar(Cliente cliente) throws Exception;
}
