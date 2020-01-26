package br.fiap.telegram.options;

public enum Enum {

	 START("/start", "Inicio com menu de boas vindas")
	,ABRIR_CONTA("/abrirconta", "Abrir uma nova conta")
	,MODIFICAR_CONTA("/modificarconta", "Atualiza informacoes da conta")
	,EXIBIR_DADOS("/exibirdados", "Exibe os dados da sua conta")
	,DEPOSITO("/deposito", "Deposita um valor (formato R$ 99.99)")
	,SAQUE("/saque", "Saca um valor (formato R$ 99.99)")
	,EXTRATO("/extrato", "Extrato da conta")
	,LANCAMENTOS("/lancamentos", "Resumos dos lançamentos")
	,RETIRADAS("/retiradas", "Resumo dos saques")
	,TARIFAS("/tarifas", "Resumo de tarifas geradas")
	,AJUDA("/ajuda", "Ajuda");

	public String codigo;
	public String descricao;

	Enum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static Enum getByCodigo(String codigo) {
		for (Enum comandoEnum : Enum.values()) {
			if (comandoEnum.codigo.equals(codigo)) {
				return comandoEnum;
			}
		}
		return null;
	}
}
