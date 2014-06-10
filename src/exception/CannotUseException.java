package exception;
public class CannotUseException extends Exception
{
	public CannotUseException()
	{
		super("你无权使用此功能!");
	}
	public CannotUseException(String message)
	{
		super(message);
	}
}
