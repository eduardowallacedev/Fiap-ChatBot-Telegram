package br.fiap.telegram.options;

import br.fiap.telegram.model.Cliente;

public class Factory {

    public static Opcoes getComando(Cliente cliente) {

        Enum comando = Enum.getByCodigo(cliente.getMensagemAtual());

        if (comando == null) {
            comando = Enum.getByCodigo(cliente.getComandoAtual());
        }

        if (comando != null) {

            cliente.setComandoAtual(comando.codigo);

            switch (comando) {

                case START: {
                    return new Start();
                }

                case ABRIR_CONTA: {
                    return new AbrirConta();
                }

                case MODIFICAR_CONTA: {
                    return new ModificarConta();
                }


                case EXIBIR_DADOS: {
                    return new ExibirDados();
                }

                case DEPOSITO: {
                    return new Deposito();
                }

                case SAQUE: {
                    return new Saque();
                }

                case EXTRATO: {
                    return new Extrato();
                }          

                case LANCAMENTOS: {
                    return new Lancamentos();
                }

                case RETIRADAS: {
                    return new Retiradas();
                }

                case TARIFAS: {
                    return new Tarifas();
                }

                case AJUDA: {
                    return new Ajuda();
                }
            }

        }

        return new NaoEncontrado();


    }
}
