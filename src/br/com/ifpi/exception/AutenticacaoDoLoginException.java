package br.com.ifpi.exception;

@SuppressWarnings("serial")
public class AutenticacaoDoLoginException extends Exception{
	
	public AutenticacaoDoLoginException(String mensagem){
		super(mensagem);
	}

}
