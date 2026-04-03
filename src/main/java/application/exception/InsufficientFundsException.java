package application.exception;

public class InsufficientFundsException extends RuntimeException{
	
	private static final long serialVersionUID = 6711703872784588433L;

	public InsufficientFundsException() {
	}
	
	public InsufficientFundsException(String message) {
		super(message);
	}
}
