package br.com.gestaofarmacia.core.util.exception;

public class NegocioException extends Exception{
	
private static final long serialVersionUID = 1L;
	
	private String mensagemDeErro;
	
	public NegocioException() {
		
	}
	
	public NegocioException(String excecao) {
		this.mensagemDeErro = excecao;
	}

	public String getMensagemDeErro() {
		return mensagemDeErro;
	}

	public void setMensagemDeErro(String mensagemDeErro) {
		this.mensagemDeErro = mensagemDeErro;
	}	

}


