package exception;

public class NoInputException extends Exception{
	public NoInputException() {
		super("你没有输入任何文本!");
	}

	public NoInputException(String message) {
		super(message);
	}
}
