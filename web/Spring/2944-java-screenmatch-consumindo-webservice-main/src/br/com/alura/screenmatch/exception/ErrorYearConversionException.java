package br.com.alura.screenmatch.exception;

public class ErrorYearConversionException extends RuntimeException {

	private String message;
	
	public ErrorYearConversionException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	
	
	
	

}
