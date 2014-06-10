package exception;

public class WrongPasswordException extends Exception{
	public WrongPasswordException() {
		super("ÃÜÂë´íÎó!");
	}

	public WrongPasswordException(String message) {
		super(message);
	}
}
