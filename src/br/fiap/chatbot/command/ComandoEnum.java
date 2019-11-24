package br.fiap.chatbot.command;

public enum ComandoEnum {

    START("/start","Inicio com menu de boas vindas"),
    ABRIR_CONTA("/abrirconta","Abrir uma nova conta"),
    MODIFICAR_CONTA("/modificarconta","Atualiza informacoes da conta"),
    EXIBIR_DADOS("/exibirdados", "Exibe os dados da sua conta"),
    DEPOSITO("/deposito", "Deposita um valor (formato R$ 99.99)"),
    SAQUE("/saque","Saca um valor (formato R$ 99.99)"),
    EXTRATO("/extrato","Extrato da conta"),
    EMPRESTIMO("/emprestimo","Emprestimos efetuados"),
    SALDO_DEVEDOR("/saldodevedor","Saldo devedor de emprestimos"),
    LANCAMENTOS("/lancamentos","Resumos dos lan�amentos"),
    RETIRADAS("/retiradas","Resumo dos saques"),
    TARIFAS("/tarifas", "Resumo de tarifas geradas"),
    AJUDA("/ajuda","Ajuda");


    public String codigo;
    public String descricao;

    ComandoEnum(String codigo,String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static ComandoEnum getByCodigo(String codigo) {
        for (ComandoEnum comandoEnum : ComandoEnum.values()) {
            if (comandoEnum.codigo.equals(codigo)) {
                return comandoEnum;
            }
        }
        return null;
    }
}
