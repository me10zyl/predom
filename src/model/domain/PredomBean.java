package model.domain;
public class PredomBean implements Bean
{
	int functionId;
	
	int predomId;
	int userGroupId;
	public PredomBean()
	{
	}
	public PredomBean(int functionId, int predomId, int userGroupId)
	{
		super();
		this.functionId = functionId;
		this.predomId = predomId;
		this.userGroupId = userGroupId;
	}
	public int getFunctionId()
	{
		return functionId;
	}
	public int getPredomId()
	{
		return predomId;
	}
	public int getUserGroupId()
	{
		return userGroupId;
	}
	public void setFunctionId(int functionId)
	{
		this.functionId = functionId;
	}
	public void setPredomId(int predomId)
	{
		this.predomId = predomId;
	}
	public void setUserGroupId(int userGroupId)
	{
		this.userGroupId = userGroupId;
	}
	
}
