package model.db.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.domain.Bean;
import model.domain.UserBean;

/**
 * �û�DataAcessObject
 * 
 * @author ZyL
 * 
 */
public class UserDAO extends DAO
{
	/**
	 * @param record
	 *                һ����¼ ���һ����¼
	 */
	@Override
	public void add(Bean record) throws SQLException, ClassNotFoundException
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		sql = "insert into users(userGroup_id,user_name,user_address,user_code,user_phone,user_email,user_password) values(?,?,?,?,?,?,?)";
		ps = getPrepareStatement(sql);
		// ������
		UserBean userBean = (UserBean) record;
		ps.setInt(1, userBean.getUserGroupId());
		ps.setString(2, userBean.getUserName());
		ps.setString(3, userBean.getUserAddress());
		ps.setString(4, userBean.getUserCode());
		ps.setString(5, userBean.getUserPhone());
		ps.setString(6, userBean.getUserEmail());
		ps.setString(7, userBean.getUserPassword());
		// ִ��SQL���
		int res = ps.executeUpdate();
		if (res == 1)
		{
			System.out.println("��ӳɹ�Ŷ");
		}
		release();
	}
	/**
	 * �����ݿ�ĵ�����¼(assemble���)
	 * 
	 * @param rs
	 *                �����
	 * @param record
	 * @return Vector<String>
	 * @throws SQLException
	 */
	public Bean assemble(ResultSet rs) throws SQLException
	{
		Vector<String> record = new Vector<String>();
		record.add(rs.getInt("user_id") + "");
		record.add(rs.getInt("userGroup_id") + "");
		record.add(rs.getString("user_name"));
		record.add(rs.getString("user_address"));
		record.add(rs.getString("user_code"));
		record.add(rs.getString("user_phone"));
		record.add(rs.getString("user_email"));
		record.add(rs.getString("user_password"));
		UserBean userBean = new UserBean(Integer.parseInt(record.get(0)), Integer.parseInt(record.get(1)), record.get(2), record.get(3), record.get(4), record.get(5), record.get(6), record.get(7));
		return userBean;
	}
	@Override
	public void deleteById(int id) throws ClassNotFoundException, SQLException
	{
		sql = "delete  from users where user_id=?";
		ps  = getPrepareStatement(sql);
		ps.setInt(1, id);
		int res =  ps.executeUpdate();
		if(res == 1)
		{
			System.out.println("ɾ���ɹ�");
		}
	}
	@Override
	public Vector<Bean> getAll() throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		sql = "select * from users";
		ps = getPrepareStatement(sql);
		// ִ��SQL���
		rs = ps.executeQuery();
		// �����ѯ���
		Bean bean = null;
		Vector<Bean> records = new Vector<Bean>();
		while (rs.next())
		{
			bean = assemble(rs);
			records.add(bean);
		}
		release();
		return records;
	}
	@Override
	public Bean getById(int id) throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		sql = "select * from users where user_id=?";
		ps = getPrepareStatement(sql);
		// ������
		ps.setInt(1, id);
		// ִ��SQL���
		rs = ps.executeQuery();
		// �����ѯ���
		Bean bean = null;
		// һ��Vector����һ����¼
		if (rs.next())
		{
			bean = assemble(rs);
		}
		release();
		return bean;
	}
	@Override
	public void modifyById(int id, Bean record) throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		sql = "update users set userGroup_id=?,user_name=?,user_address=?,user_code=?,user_phone=?,user_email=?,user_password=? where user_id=?";
		ps = getPrepareStatement(sql);
		UserBean userBean = (UserBean) record;
		ps.setInt(1, userBean.getUserGroupId());
		ps.setString(2, userBean.getUserName());
		ps.setString(3, userBean.getUserAddress());
		ps.setString(4, userBean.getUserCode());
		ps.setString(5, userBean.getUserPhone());
		ps.setString(6, userBean.getUserEmail());
		ps.setString(7, userBean.getUserPassword());
		ps.setInt(8, id);
		int res = ps.executeUpdate();
		if (res == 1)
		{
			System.out.println("�޸ĳɹ�");
		}
	}
}
