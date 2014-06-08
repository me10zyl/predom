package model.db.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.domain.Bean;
import model.domain.PredomBean;
import model.domain.UserBean;

/**
 * 用户DataAcessObject
 * 
 * @author ZyL
 * 
 */
public class PredomDAO extends DAO
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
		sql = "insert into predom(userGroup_id,function_id) values(?,?)";
		ps = getPrepareStatement(sql);
		// 参数绑定
		PredomBean predomBean = (PredomBean) record;
		ps.setInt(1, predomBean.getUserGroupId());
		ps.setInt(2, predomBean.getFunctionId());
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
		Vector<Integer> record = new Vector<Integer>();
		record.add(rs.getInt("function_id"));
		record.add(rs.getInt("predom_id") );
		record.add(rs.getInt("userGroup_id") );
		PredomBean predomBean = new PredomBean(record.get(0).intValue(), record.get(1).intValue(), record.get(2).intValue());
		return predomBean;
	}
	public Vector<Bean> getFunctionsBeansByUserGroupId(int userGroupId) throws SQLException, ClassNotFoundException
	{
		// TODO Auto-generated method stub
		sql = "select * from functions where function_id in (select function_id from predom where userGroup_id=?)";
		ps = getPrepareStatement(sql);
		// 参数绑定
		ps.setInt(1, userGroupId);
		// 执行SQL语句
		rs = ps.executeQuery();
		// 处理查询结果
		Bean bean = null;
		// 一个Vector就是一条记录
		Vector<Bean> functionsBeans= new Vector<Bean>();
		FuntionsDAO functionsDAO = new FuntionsDAO();
		while (rs.next())
		{
			bean = functionsDAO.assemble(rs);
			functionsBeans.add(bean);
		}
		release();
		return functionsBeans;
	}
	 public void deleteByUserGroupIdAndFunctionId(int userGroupId,int functionId) throws ClassNotFoundException, SQLException
	{
		sql = "delete  from predom where userGroup_id=? and function_id=?";
		ps  = getPrepareStatement(sql);
		ps.setInt(1, userGroupId);
		ps.setInt(2, functionId);
		int res =  ps.executeUpdate();
		if(res == 1)
		{
			System.out.println("删除成功");
		}
	}
	public Vector<Bean> getOtherFunctionsBeansByUserGroupId(int userGroupId) throws SQLException, ClassNotFoundException
	{
		// TODO Auto-generated method stub
		sql = "select * from functions where function_id not in (select function_id from predom where userGroup_id=?)";
		ps = getPrepareStatement(sql);
		// 参数绑定
		ps.setInt(1, userGroupId);
		// 执行SQL语句
		rs = ps.executeQuery();
		// 处理查询结果
		Bean bean = null;
		// 一个Vector就是一条记录
		Vector<Bean> functionsBeans= new Vector<Bean>();
		FuntionsDAO functionsDAO = new FuntionsDAO();
		while (rs.next())
		{
			bean = functionsDAO.assemble(rs);
			functionsBeans.add(bean);
		}
		release();
		return functionsBeans;
	}
	@Override
	public void deleteById(int id) throws ClassNotFoundException, SQLException
	{
		sql = "delete  from predom where predom_id=?";
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
		sql = "select * from predom";
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
		sql = "select * from predom where predom_id=?";
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
		sql = "update predom set userGroup_id=?,function_id=? where predom_id=?";
		ps = getPrepareStatement(sql);
		PredomBean predomBean = (PredomBean) record;
		ps.setInt(1, predomBean.getUserGroupId());
		ps.setInt(2, predomBean.getFunctionId());
		ps.setInt(3, predomBean.getPredomId());
		int res = ps.executeUpdate();
		if (res == 1)
		{
			System.out.println("修改成功");
		}
	}
}
