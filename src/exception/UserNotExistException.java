package exception;

public class UserNotExistException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotExistException() {
		super("�û�������!");
	}

	public UserNotExistException(String message) {
		super(message);
	}
}
