package application.exception;

public class EntityNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 6711703872784588433L;

	public EntityNotFoundException() {
	}
	
	public EntityNotFoundException(String message) {
		super(message);
	}
}
