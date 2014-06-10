package model;
import java.sql.SQLException;
import util.PredomManager;
import model.db.dao.UserDAO;
import model.domain.UserBean;
import exception.NoInputException;
import exception.UserNotExistException;
import exception.WrongPasswordException;

public class Login
{
	String loginname;
	String password;

	public Login(String loginname, String password)
	{
		super();
		this.loginname = loginname;
		this.password = password;
	}
	public String login() throws NoInputException, WrongPasswordException, UserNotExistException, SQLException, ClassNotFoundException
	{
		String result = null;
		// 判定是否输入了登陆名和密码
		// 没输入,返回请输入邓玲和密码
		if (loginname == null || loginname.equals("") || password == null || password.equals(""))
		{
			result = "请输入登录名和密码";
			throw new NoInputException("登录名密码空");
		} else
		{
			UserBean userBean = new UserDAO().getUserBeanByEmail(loginname);
			// 输入了,判定登录名的用户在系统中是否存在
			if(userBean != null)
			{
				if (loginname.equals(userBean.getUserEmail()))
				{
					System.out.println(password);
					System.out.println(userBean.getUserPassword());
					// 存在,判定密码是否存在
					if (password.equals(userBean.getUserPassword()))
					{
						// 正确,返回登陆成功
						result = "登陆成功";
						PredomManager.setUser(userBean);
					} else
					{
						// 不正确,返回密码错误
						throw new WrongPasswordException("密码错误");
					}
				}
			}else
			{
				// 不存在，返回用户不存在
				throw new UserNotExistException("用户不存在");
			}
		
				
				
		}
		return result;
	}
}
