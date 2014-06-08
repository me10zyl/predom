package model.domain;
public class FunctionsBean implements Bean
{
	private int function_id;
	private String function_name;
	private String function_note;
	public FunctionsBean(int function_id, String function_name, String function_note)
	{
		super();
		this.function_id = function_id;
		this.function_name = function_name;
		this.function_note = function_note;
	}
	public FunctionsBean()
	{
		// TODO Auto-generated constructor stub
	}
	public int getFunction_id()
	{
		return function_id;
	}
	public void setFunction_id(int function_id)
	{
		this.function_id = function_id;
	}
	public String getFunction_name()
	{
		return function_name;
	}
	public void setFunction_name(String function_name)
	{
		this.function_name = function_name;
	}
	public String getFunction_note()
	{
		return function_note;
	}
	public void setFunction_note(String function_note)
	{
		this.function_note = function_note;
	}
}
