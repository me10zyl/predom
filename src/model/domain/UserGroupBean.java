package model.domain;
public class UserGroupBean implements Bean
{
	private int userGroupId;
	private String userGroupName;
	public UserGroupBean()
	{
	}
	public UserGroupBean(int userGroupId, String userGroupName)
	{
		super();
		this.userGroupId = userGroupId;
		this.userGroupName = userGroupName;
	}

	@Override
	public boolean equals(Object obj)
	{
		return this.userGroupId == ((UserGroupBean) obj).getUserGroupId();
	}
	public int getUserGroupId()
	{
		return userGroupId;
	}
	public String getUserGroupName()
	{
		return userGroupName;
	}
	public void setUserGroupId(int userGroupId)
	{
		this.userGroupId = userGroupId;
	}
	public void setUserGroupName(String userGroupName)
	{
		this.userGroupName = userGroupName;
	}
	@Override
	public String toString()
	{
		return userGroupName;
	}
	
}
