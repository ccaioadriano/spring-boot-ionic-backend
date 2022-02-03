package br.com.curso.comercio.services.exceptions;

public class ObjetoNaoEncontrado extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjetoNaoEncontrado(String mensagem) {
		super(mensagem);
	}
	
	public ObjetoNaoEncontrado(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
