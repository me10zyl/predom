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
		// �ж��Ƿ������˵�½��������
		// û����,������������������
		if (loginname == null || loginname.equals("") || password == null || password.equals(""))
		{
			result = "�������¼��������";
			throw new NoInputException("��¼�������");
		} else
		{
			UserBean userBean = new UserDAO().getUserBeanByEmail(loginname);
			// ������,�ж���¼�����û���ϵͳ���Ƿ����
			if(userBean != null)
			{
				if (loginname.equals(userBean.getUserEmail()))
				{
					System.out.println(password);
					System.out.println(userBean.getUserPassword());
					// ����,�ж������Ƿ����
					if (password.equals(userBean.getUserPassword()))
					{
						// ��ȷ,���ص�½�ɹ�
						result = "��½�ɹ�";
						PredomManager.setUser(userBean);
					} else
					{
						// ����ȷ,�����������
						throw new WrongPasswordException("�������");
					}
				}
			}else
			{
				// �����ڣ������û�������
				throw new UserNotExistException("�û�������");
			}
		
				
				
		}
		return result;
	}
}
