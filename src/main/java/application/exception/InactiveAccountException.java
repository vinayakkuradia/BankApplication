package application.exception;

public class InactiveAccountException extends RuntimeException{
	
	private static final long serialVersionUID = 6711703872784588433L;

	public InactiveAccountException() {
	}
	
	public InactiveAccountException(String message) {
		super(message);
	}
}
