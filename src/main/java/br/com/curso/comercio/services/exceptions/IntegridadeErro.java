package br.com.curso.comercio.services.exceptions;

public class IntegridadeErro extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public IntegridadeErro(String mensagem) {
		super(mensagem);
	}
	
	public IntegridadeErro(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
