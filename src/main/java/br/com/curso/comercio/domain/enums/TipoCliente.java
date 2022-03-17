package br.com.curso.comercio.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Fisica"), PESSOAJURIDICA(2, "Pessoa Juridica");

	private Integer codigo;
	private String descricao;

	private TipoCliente(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static TipoCliente toEnum(Integer codigoCliente) {

		if (codigoCliente == null) {
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) {

			if (codigoCliente.equals(x.getCodigo())) {
				return x;
			} else {
				throw new IllegalArgumentException("Código do cliente inválido: " + codigoCliente);
			}

		}
		return null;
	}

}
