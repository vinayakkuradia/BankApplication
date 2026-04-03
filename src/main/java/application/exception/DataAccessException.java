package application.exception;

public class DataAccessException extends RuntimeException{
	
	private static final long serialVersionUID = 6711703872784588433L;

	public DataAccessException() {
	}
	
	public DataAccessException(String message) {
		super(message);
	}
}
