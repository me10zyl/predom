package model.db.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.domain.Bean;
import model.domain.UserBean;

/**
 * 用户DataAcessObject
 * 
 * @author ZyL
 * 
 */
public class UserDAO extends DAO
{
	/**
	 * @param record
	 *                一条记录 添加一条记录
	 */
	@Override
	public void add(Bean record) throws SQLException, ClassNotFoundException
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		sql = "insert into users(userGroup_id,user_name,user_address,user_code,user_phone,user_email,user_password) values(?,?,?,?,?,?,?)";
		ps = getPrepareStatement(sql);
		// 参数绑定
		UserBean userBean = (UserBean) record;
		ps.setInt(1, userBean.getUserGroupId());
		ps.setString(2, userBean.getUserName());
		ps.setString(3, userBean.getUserAddress());
		ps.setString(4, userBean.getUserCode());
		ps.setString(5, userBean.getUserPhone());
		ps.setString(6, userBean.getUserEmail());
		ps.setString(7, userBean.getUserPassword());
		// 执行SQL语句
		int res = ps.executeUpdate();
		if (res == 1)
		{
			System.out.println("添加成功哦");
		}
		release();
	}
	/**
	 * 将数据库的单条记录(assemble汇聚)
	 * 
	 * @param rs
	 *                结果集
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
			System.out.println("删除成功");
		}
	}
	@Override
	public Vector<Bean> getAll() throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		sql = "select * from users";
		ps = getPrepareStatement(sql);
		// 执行SQL语句
		rs = ps.executeQuery();
		// 处理查询结果
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
		// 参数绑定
		ps.setInt(1, id);
		// 执行SQL语句
		rs = ps.executeQuery();
		// 处理查询结果
		Bean bean = null;
		// 一个Vector就是一条记录
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
			System.out.println("修改成功");
		}
	}
}
