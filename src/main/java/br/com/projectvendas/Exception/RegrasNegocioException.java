package br.com.projectvendas.Exception;

public class RegrasNegocioException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RegrasNegocioException() {
	}
	
	public RegrasNegocioException(String message) {
		super(message);
	}
}
