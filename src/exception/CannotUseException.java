package exception;
public class CannotUseException extends Exception
{
	public CannotUseException()
	{
		super("����Ȩʹ�ô˹���!");
	}
	public CannotUseException(String message)
	{
		super(message);
	}
}
