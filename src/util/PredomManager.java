package util;
import java.awt.AWTEvent;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import exception.CannotUseException;
import model.db.dao.PredomDAO;
import model.db.dao.UserDAO;
import model.domain.Bean;
import model.domain.FunctionsBean;
import model.domain.UserBean;

public class PredomManager
{
	public static UserBean user;

	public static UserBean getUser()
	{
		return user;
	}
	public static void setUser(UserBean user)
	{
		PredomManager.user = user;
	}
	public PredomManager(UserBean user)
	{
		this.user = user;
	}
	public static void canUse(AWTEvent event) throws ClassNotFoundException, SQLException, CannotUseException
	{
		PredomDAO predomDAO = new PredomDAO();
		Vector<Bean> functionsBeans = predomDAO.getFunctionsBeansByUserGroupId(user.getUserGroupId());
		boolean canUse = false;
		for (Bean bean : functionsBeans)
		{
			String function_name = ((FunctionsBean) bean).getFunction_name();
			// 一旦用户的functionS其中一个等于当前组件的Name，就可以使用
			if (((JComponent) event.getSource()).getName().equals(function_name))
			{
				canUse = true;
				break;
			}
		}
//		canUse = true;
		if (!canUse)
		{
			CannotUseException cannotUseException = new CannotUseException();
			JOptionPane.showMessageDialog(null, cannotUseException.getMessage());
			throw cannotUseException;
		}
	}
}
