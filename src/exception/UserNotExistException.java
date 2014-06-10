package exception;

public class UserNotExistException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotExistException() {
		super("用户不存在!");
	}

	public UserNotExistException(String message) {
		super(message);
	}
}
