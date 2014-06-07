package model.db.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.domain.Bean;

/**
 * 所有数据库操作类的父类
 * 
 * @author ZyL
 * 
 */
abstract public class DAO
{
	protected Connection connection = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	protected String sql = null;

	// ========================================
	/**
	 * 
	 * @param sql
	 *                SQL语句
	 * @return PreparedStatement对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected PreparedStatement getPrepareStatement(String sql) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		connection = DriverManager.getConnection("jdbc:sqlserver://100.1.0.46:1433;dataBase=predomApp", "sa", "sa");
		ps = connection.prepareStatement(sql);
		return ps;
	}
	public void release() throws SQLException
	{
		if (rs != null)
		{
			rs.close();
		}
		if (ps != null)
		{
			ps.close();
		}
		if (connection != null)
		{
			connection.close();
		}
	}
	public abstract Vector<Bean> getAll() throws ClassNotFoundException, SQLException;
	public abstract Bean getById(int id) throws ClassNotFoundException, SQLException;
	public abstract void add(Bean record) throws ClassNotFoundException, SQLException;
	public abstract void modifyById(int id, Bean record) throws ClassNotFoundException, SQLException;
	public abstract void deleteById(int id) throws ClassNotFoundException, SQLException;
	/**
	 * ResultSet转换为Vector<String>
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public abstract Bean assemble(ResultSet rs) throws SQLException;
	{
		// TODO Auto-generated method stub
		
	}
}
