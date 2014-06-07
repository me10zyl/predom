package model.domain;
public class UserBean implements Bean
{
	private String userAddress;
	private String userCode;
	private String userEmail;
	private int userGroupId;
	private int userId;
	private String userName;
	private String userPassword;
	private String userPhone;

	public UserBean()
	{
	}
	public UserBean(int userId, int userGroupId, String userName, String userAddress, String userCode, String userPhone, String userEmail, String userPassword)
	{
		super();
		this.userAddress = userAddress;
		this.userCode = userCode;
		this.userEmail = userEmail;
		this.userGroupId = userGroupId;
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
	}
	public String getUserAddress()
	{
		return userAddress;
	}
	public String getUserCode()
	{
		return userCode;
	}
	public String getUserEmail()
	{
		return userEmail;
	}
	public int getUserGroupId()
	{
		return userGroupId;
	}
	public int getUserId()
	{
		return userId;
	}
	public String getUserName()
	{
		return userName;
	}
	public String getUserPassword()
	{
		return userPassword;
	}
	public String getUserPhone()
	{
		return userPhone;
	}
	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}
	public void setUserCode(String userCode)
	{
		this.userCode = userCode;
	}
	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}
	public void setUserGroupId(int userGroupId)
	{
		this.userGroupId = userGroupId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}
	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
	}
	@Override
	public boolean equals(Object obj)
	{
		return this.userId == ((UserBean) obj).getUserId();
	}
}
