package exception;

public class NoInputException extends Exception{
	public NoInputException() {
		super("��û�������κ��ı�!");
	}

	public NoInputException(String message) {
		super(message);
	}
}
