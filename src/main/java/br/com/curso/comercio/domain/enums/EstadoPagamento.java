package br.com.curso.comercio.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");

	private Integer codigo;
	private String descricao;

	private EstadoPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static EstadoPagamento toEnum(Integer codigoPagamento) {

		if (codigoPagamento == null) {
			return null;
		}

		for (EstadoPagamento x : EstadoPagamento.values()) {

			if (codigoPagamento.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + codigoPagamento);
	}

}
